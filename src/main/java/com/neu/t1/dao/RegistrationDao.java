package com.neu.t1.dao;

import com.neu.t1.po.*;
import com.neu.t1.vo.CostDetailVO;
import com.neu.t1.vo.InvoiceVO;
import com.neu.t1.vo.RegReturnVo;
import com.neu.t1.vo.SettlementVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 挂号相关操作
 * 获取病历号
 */

public interface RegistrationDao {

    //根据身份证号查找病历号
    Integer generateMedicalRecord(@Param("id_number") String id_number);
    //查找最大病历号
    Integer getMaxMedicalRecordNum();
    //查找最大挂号号码
    Integer getMaxRegNum();

    List<Map<String, Object>> getDocList(@Param("depName")Integer depName, @Param("regType")Integer regType);

    List<Map<String, Object>> getRegType();

    List<Map<String, Object>> getDepMsg();

    List<Map<String, Object>> getGender();

    List<Map<String, Object>> getMedicalNum();

    List<Map<String, Object>> getChargeType();

    Map<String, Object> getPatientMsg(@Param("medicalNum") Integer medicalNum);

    Integer getLeft(@Param("docNum") Integer docNum);

    Integer getMaxInvoice();

    void addRegistMsg(@Param("returnVo") RegReturnVo regReturnVo);

    List<RegistMsg> getRegistMsg(@Param("medicalrecordid") Integer medicalrecordid);

    void withdrawRegis(@Param("registid") Integer registid);

    List<PayType> getPayType();

    List<Integer> getPrescriptionID(@Param("settlement") SettlementVO settlementVO);

    List<PreFee> getDrugList(@Param("preid") Integer i);

    void settlement(@Param("preid") Integer i);

    List<PrescriptionPO> getPrescription(@Param("settlement") SettlementVO settlementVO);

    List<CostDetail> getCostDetail(@Param("prescriptionid") Integer prescriptionID);

    Integer getDocID(@Param("docid") String docid);

    void addCostDetail(@Param("cd") CostDetail cd);

    void addInvoice(@Param("invoicenum") Integer invoicenum, @Param("fee") double fee, @Param("createtime") String format, @Param("docid") Integer docid,@Param("registid") Integer registid,@Param("chargetype") Integer chargetype);

    List<PrescriptionDetailPO> getPreMsg(@Param("medicalrecordid") Integer medicalrecordid);

    void addCostDetail1(@Param("cd") CostDetailVO costDetailVO);

    void changePdiStatus(@Param("pdi") Integer pdi);

    Integer getInvoiceID(@Param("invoiceid") Integer invoicenum);

    void addInvoice1(@Param("invoice") InvoiceVO invoiceVO);

    void distributemedicine(@Param("pdi") String pdi);

    List<PrescriptionDetailPO> getPreMsgMedicine(@Param("medicalrecordid") Integer medicalrecordid);
}
