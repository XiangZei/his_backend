package com.neu.t1.Service;

import com.neu.t1.dao.DiagnoseDao;
import com.neu.t1.po.*;
import com.neu.t1.vo.*;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 诊断服务的实现类，具体方法的注解在接口类中
 */
@Service("diagnoseService")
@Transactional
public class DiagnoseServiceImpl implements DiagnoseService {
    @Autowired
    DiagnoseDao diagnoseDao;
    @Override
    public List<Map<String, Object>> getPatientList(String docName) {
        List<Map<String,Object>> list = diagnoseDao.getPatientList(docName);
        return list;
    }

    @Override
    public boolean submitMedicalMainPage(MedicalMainPage mainPage) {
        if(diagnoseDao.findDup(mainPage.getRegistid(),mainPage.getMedicalrecordid())==null){
            diagnoseDao.submitMedicalMainPage(mainPage);
            return true;
        }
        return false;
    }

    @Override
    public Integer addPrescription(Prescription prescription) {
        Integer prescriptionid = diagnoseDao.getMaxPrescriptionID();

        System.out.println("最大的处方id为"+prescriptionid);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        prescription.setCreatetime(sdf.format(date));
        prescription.setPrescriptionid(prescriptionid);
        Integer docid = diagnoseDao.getDocID(prescription.getDocid());
        prescription.setDoc(docid);
        diagnoseDao.addPrescription(prescription);
        return prescriptionid;

    }

    @Override
    public boolean filldetail(PrescriptionDetailVO prescriptionDetailVO) {
        diagnoseDao.filldetail(prescriptionDetailVO);
        return true;
    }

    @Override
    public void changeStatus(Integer registid) {
        diagnoseDao.changeStatus(registid);
    }

    @Override
    public boolean cancel(CancelVO cancelVO) {
        diagnoseDao.cancel(cancelVO);
        return true;
    }

    @Override
    public List<DrugPO> searchdrug(String code) {
        List<DrugPO> drugPOList = diagnoseDao.searchdrug(code);
        return drugPOList;
    }

    @Override
    public List<PrescriptionTemplate> getPrescriptionTemplateList() {
        List<PrescriptionTemplate> list = diagnoseDao.getPrescriptionTemplateList();

        return list;
    }

    @Override
    public List<PrescriptionDetail> getPrescriptionDetail(Integer id) {
        List<PrescriptionDetail> list =diagnoseDao.getPrescriptionDetail(id);
        return list;
    }

    @Override
    public List<IllnessCata> getIllnessCata() {
        List<IllnessCata> list = diagnoseDao.getIllnessCata();
        return list;
    }

    @Override
    public List<Ill> searchIll(Integer cataid) {
        List<Ill> list = diagnoseDao.searchIll(cataid);
        return list;
    }

    @Override
    public boolean addFirstDiagnose(DiagnoseVO diagnoseVO) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        diagnoseVO.setDiagnosetime(sdf.format(date));
        diagnoseDao.addFirstDiagnose(diagnoseVO);
        return true;
    }

    @Override
    public List<DiagnosePO> getDiagnose(Integer medicalrecordid, Integer registid) {
        List<DiagnosePO> list = diagnoseDao.getDiagnose(medicalrecordid,registid);
        return list;
    }

    @Override
    public boolean finishdiagnose(Object registid) {
        Integer a = diagnoseDao.finishdiagnose(registid.toString());
        return a!=null;
    }

    @Override
    public Integer coverMedicalMainPage(MedicalMainPage medicalMainPage) {
        diagnoseDao.deleteFirstDiagnose(medicalMainPage.getRegistid(),medicalMainPage.getMedicalrecordid());
        return diagnoseDao.coverMedicalMainPage(medicalMainPage);
    }
}
