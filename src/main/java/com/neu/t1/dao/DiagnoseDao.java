package com.neu.t1.dao;

import com.neu.t1.po.*;
import com.neu.t1.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 实现诊断的mybatis方法接口
 */
public interface DiagnoseDao {
    /**
     * 获取病人列表
     */
    List<Map<String, Object>> getPatientList(@Param("docName") String docName);

    /**
     *提交门诊病历首页
     */
    void submitMedicalMainPage(@Param("mainPage") MedicalMainPage mainPage);

    /**
     *改变就诊状态
     */
    void changeStatus(@Param("registid") Integer registid);

    /**
     *增加处方
     */
    void addPrescription(@Param("prescription") Prescription prescription);

    /**
     *获取最大处方id
     */
    Integer getMaxPrescriptionID();

    /**
     * 增加处方明细
     */
    void filldetail(@Param("prescriptiondetail") PrescriptionDetailVO prescriptionDetailVO);

    /**
     * 处方作废
     */
    void cancel(@Param("cancel") CancelVO cancelVO);

    /**
     *根据药品助记码模糊匹配药品信息
     */
    List<DrugPO> searchdrug(@Param("code") String code);

    /**
     *根据医生用户名获取医生id
     */
    Integer getDocID(@Param("docname") String docid);

    /**
     *获取处方模板列表
     */
    List<PrescriptionTemplate> getPrescriptionTemplateList();

    /**
     *获取处方明细列表
     */
    List<PrescriptionDetail> getPrescriptionDetail(@Param("id") Integer id);

    /**
     *获取疾病分类
     */
    List<IllnessCata> getIllnessCata();

    /**
     *根据疾病分类搜索疾病
     */
    List<Ill> searchIll(@Param("cataid") Integer cataid);

    /**
     *增加初诊结果
     */
    void addFirstDiagnose(@Param("diagnose") DiagnoseVO diagnoseVO);

    /**
     *获取指定病人指定挂号下的诊断结果
     */
    List<DiagnosePO> getDiagnose(@Param("medicalrecordid") Integer medicalrecordid,@Param("registid") Integer registid);

    /**
     *诊毕
     */
    Integer finishdiagnose(@Param("registid") String toString);

    /**
     *搜索是否病历号重复
     */
    Integer findDup(@Param("registid") Integer registid,@Param("medicalrecordid") Integer medicalrecordid);

    /**
     *删除初诊内容
     */
    void deleteFirstDiagnose(@Param("registid") Integer registid,@Param("medicalrecordid") Integer medicalrecordid);

    /**
     *更新门诊病历首页
     */
    Integer coverMedicalMainPage(@Param("mainPage") MedicalMainPage medicalMainPage);
}
