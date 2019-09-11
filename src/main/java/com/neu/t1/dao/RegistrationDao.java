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

    /**
     *根据身份证号查找病历号
     */
    Integer generateMedicalRecord(@Param("id_number") String id_number);

    /**
     *查找最大病历号
     */
    Integer getMaxMedicalRecordNum();

    /**
     *查找最大挂号号码
     */
    Integer getMaxRegNum();

    /**
     *根据科室名称和挂号类别，获取医生列表
     */
    List<Map<String, Object>> getDocList(@Param("depName")Integer depName, @Param("regType")Integer regType);

    /**
     *获取挂号类别
     */
    List<Map<String, Object>> getRegType();

    /**
     *获取科室信息
     */
    List<Map<String, Object>> getDepMsg();

    /**
     *获取性别列表
     */
    List<Map<String, Object>> getGender();

    /**
     *获取所有的病历号
     */
    List<Map<String, Object>> getMedicalNum();

    /**
     *获取收费类型
     */
    List<Map<String, Object>> getChargeType();

    /**
     *根据病历号获取病人信息
     */
    Map<String, Object> getPatientMsg(@Param("medicalNum") Integer medicalNum);

    /**
     *获取对应医生的剩余号额
     */
    Integer getLeft(@Param("docNum") Integer docNum);

    /**
     *获取最大发票id
     */
    Integer getMaxInvoice();

    /**
     *增加挂号信息
     */
    void addRegistMsg(@Param("returnVo") RegReturnVo regReturnVo);

    /**
     *根据病人病历号获取病人挂号信息
     */
    List<RegistMsg> getRegistMsg(@Param("medicalrecordid") Integer medicalrecordid);

    /**
     *退号操作
     */
    void withdrawRegis(@Param("registid") Integer registid);

    /**
     *获取所有的支付类型
     */
    List<PayType> getPayType();

    /**
     *获取处方id
     */
    List<Integer> getPrescriptionID(@Param("settlement") SettlementVO settlementVO);

    /**
     *获取药品列表
     */
    List<PreFee> getDrugList(@Param("preid") Integer i);

    /**
     *处方收费
     */
    void settlement(@Param("preid") Integer i);

    /**
     *获取处方
     */
    List<PrescriptionPO> getPrescription(@Param("settlement") SettlementVO settlementVO);

    /**
     *获取消费明细
     */
    List<CostDetail> getCostDetail(@Param("prescriptionid") Integer prescriptionID);

    /**
     *获取根据医生用户名获取医生id
     */
    Integer getDocID(@Param("docid") String docid);

    /**
     *增加缴费明细
     */
    void addCostDetail(@Param("cd") CostDetail cd);

    /**
     *增加发票明细
     */
    void addInvoice(@Param("invoicenum") Integer invoicenum, @Param("fee") double fee, @Param("createtime") String format, @Param("docid") Integer docid,@Param("registid") Integer registid,@Param("chargetype") Integer chargetype);

    /**
     *获取处方明细
     */
    List<PrescriptionDetailPO> getPreMsg(@Param("medicalrecordid") Integer medicalrecordid);

    /**
     *增加缴费明细
     */
    void addCostDetail1(@Param("cd") CostDetailVO costDetailVO);

    /**
     *修改处方明细状态
     */
    void changePdiStatus(@Param("pdi") Integer pdi);

    /**
     *获取发票id
     */
    Integer getInvoiceID(@Param("invoiceid") Integer invoicenum);

    /**
     *增加发票信息
     */
    void addInvoice1(@Param("invoice") InvoiceVO invoiceVO);

    /**
     *发药操作
     */
    void distributemedicine(@Param("pdi") String pdi);

    /**
     *获取制定病历号未缴费的处方明细
     */
    List<PrescriptionDetailPO> getPreMsgMedicine(@Param("medicalrecordid") Integer medicalrecordid);
}
