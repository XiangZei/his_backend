package com.neu.t1.Service;

import com.alibaba.fastjson.JSONObject;
import com.neu.t1.dao.RegistrationDao;
import com.neu.t1.po.*;
import com.neu.t1.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 挂号服务的实现类
 */
@Service("registrationService")
@Transactional
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    RegistrationDao registrationDao;
    /*
    通过用户输入的挂号信息进行病历号和挂号的提取的确定
     */
    @Override
    public Map<String, Object> registrate(RegReturnVo regReturnVo) {
        JSONObject jsonObject = new JSONObject();
        // 获取病历号
        Integer medicalNum_ = registrationDao.generateMedicalRecord(regReturnVo.getIdNumber());
        if(medicalNum_==null){
            medicalNum_=registrationDao.getMaxMedicalRecordNum()+1;
        }
        // 获取挂号ID
        Integer regNum_ = registrationDao.getMaxRegNum()+1;
        // 获取发票ID
        Integer invoiceNum = registrationDao.getMaxInvoice()+1; //不实现发票功能，只是简单的返回发票号
        //插入信息
        if(regReturnVo.getMedicalRecord().equals("true")){
            regReturnVo.setMedicalRecorddd(1);
        }else{
            regReturnVo.setMedicalRecorddd(0);
        }
        regReturnVo.setRegNum(regNum_);
        regReturnVo.setMedicalNum(medicalNum_);
        registrationDao.addRegistMsg(regReturnVo);
        jsonObject.put("invoiceNum",invoiceNum);
        jsonObject.put("medicalNum",medicalNum_);
        jsonObject.put("registNum",regNum_);
        return jsonObject;
    }

    @Override
    public List<Map<String, Object>> getDocList(Integer depName, Integer regType) {
        List<Map<String,Object>> docList = registrationDao.getDocList(depName,regType);
        if(docList==null){
            return null;
        }
        return docList;

    }

    /**
     * 获取用户必要信息
     * @return
     */
    @Override
    public RegRequireVo getRegRequire() {
       RegRequireVo r = new RegRequireVo();
       List<Map<String,Object>> regType;
       regType = registrationDao.getRegType();
       List<Map<String,Object>> depMsg;
       depMsg = registrationDao.getDepMsg();
       List<Map<String,Object>> gender;
       gender = registrationDao.getGender();
       List<Map<String,Object>> medicalNum;
       medicalNum = registrationDao.getMedicalNum();
       List<Map<String,Object>> chargeType;
       chargeType = registrationDao.getChargeType();
       r.setGender(gender);
       r.setDepMsg(depMsg);
       r.setRegType(regType);
       r.setMedicalNum(medicalNum);
       r.setChargeType(chargeType);
        return r;
    }

    @Override
    public Map<String, Object> getPatientMsg(Integer medicalNum) {
        return registrationDao.getPatientMsg(medicalNum);
    }

    @Override
    public Integer getLeft(Integer docNum) {
        return registrationDao.getLeft(docNum);
    }

    @Override
    public List<RegistMsg> getRegistMsg(Integer medicalrecordid) {
        List<RegistMsg> list = registrationDao.getRegistMsg(medicalrecordid);
        return list;
    }

    @Override
    public boolean withdrawRegis(Integer registid) {
        registrationDao.withdrawRegis(registid);
        return true;
    }

    @Override
    public List<PayType> getPayType() {
        List<PayType> list = registrationDao.getPayType();
        return list;
    }

    @Override
    public double feeSettlement(SettlementVO settlementVO) {
        double fee=0;
        //获取所有该挂号信息下的处方ID
        List<Integer> medicalid = registrationDao.getPrescriptionID(settlementVO);
        //计算每一个处方下面的药品的总价
        for(Integer i:medicalid){
           List<PreFee> druglist = registrationDao.getDrugList(i);
           for(PreFee pf :druglist){
               fee+=pf.getDrugfee()*pf.getDrugnum();
           }
        }
        System.out.println("处方总价值为  "+fee);
        return fee;
    }

    @Override
    public void settlement(SettlementVO settlementVO) {
        double fee=0;
        //获取所有该挂号信息下的处方ID
        List<PrescriptionPO> medicalid = registrationDao.getPrescription(settlementVO);
        //获取收费医生id
        Integer docid = registrationDao.getDocID(settlementVO.getDocid());
        for(PrescriptionPO i:medicalid){
            //找到每一个处方下的对应的所有处方明细

            List<CostDetail> costDetails = registrationDao.getCostDetail(i.getPrescriptionID());
            for(CostDetail cd :costDetails){
                cd.setRegistid(i.getRegistID());
                cd.setProid(i.getPrescriptionID());
                //项目类型要从医生类型进行获取，或者从前台传来，但是没有实现，默认处理成中医
                cd.setProtype(1);
                cd.setProname(i.getMedicalrecordname());
                cd.setDepid(i.getDepartmentid());
                cd.setStarttime(i.getCreatetime());
                cd.setStartPersonID(i.getDocID());
                cd.setChargtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

                cd.setChargPersonID(docid);
                cd.setChargType(settlementVO.getChargetype());
                //增加缴费明细
                fee+= cd.getProfee()*cd.getQuantity();
                registrationDao.addCostDetail(cd);
            }
        }
        registrationDao.addInvoice(settlementVO.getInvoicenum(),fee,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),docid,settlementVO.getRegistid(),settlementVO.getChargetype());
    }

    @Override
    public List<PrescriptionDetailPO> getPreMsg(Integer medicalrecordid) {
        //获取所有该病历号下的处方ID

        List<PrescriptionDetailPO> list = registrationDao.getPreMsg(medicalrecordid);
        return list;
    }

    @Override
    public boolean Settlement(CostDetailVO costDetailVO) {
        costDetailVO.setChargetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        Integer docid = registrationDao.getDocID(costDetailVO.getStartdocid());
//        costDetailVO.setStartdocname(docid);
        Integer d = registrationDao.getDocID(costDetailVO.getDocid());
        costDetailVO.setDocname(d);
        registrationDao.addCostDetail1(costDetailVO);
        registrationDao.changePdiStatus(costDetailVO.getPdi());
        return true;
    }

    @Override
    public boolean startinvoice(InvoiceVO invoiceVO) {
        Integer a = registrationDao.getInvoiceID(invoiceVO.getInvoicenum());
        if(a!=null){
            return false;
        }
        Integer docid = registrationDao.getDocID(invoiceVO.getPersonid());
        invoiceVO.setPersonname(docid);
        invoiceVO.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        registrationDao.addInvoice1(invoiceVO);
        return true;
    }

    @Override
    public void distributemedicine(String pdi) {
        registrationDao.distributemedicine(pdi);

    }

    @Override
    public List<PrescriptionDetailPO> getPreMsgMedicine(Integer medicalrecordid) {
        List<PrescriptionDetailPO> list = registrationDao.getPreMsgMedicine(medicalrecordid);
        return list;
    }


}
