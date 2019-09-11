package com.neu.t1.Service;

import com.neu.t1.po.*;
import com.neu.t1.vo.*;

import java.util.List;
import java.util.Map;

/**
 * 诊断服务类
 */
public interface DiagnoseService {

    /**
     *获取病人列表
     */
    List<Map<String,Object>> getPatientList(String docName);

    /**
     *提交门诊病历首页
     */
    boolean submitMedicalMainPage(MedicalMainPage mainPage);

    /**
     *修改就诊状态
     */
    void changeStatus(Integer registid);

    /**
     *增加处方
     */
    Integer addPrescription(Prescription prescription);

    /**
     *增加处方明细
     */
    boolean filldetail(PrescriptionDetailVO prescriptionDetailVO);

    /**
     *处方废除
     */
    boolean cancel(CancelVO cancelVO);

    /**
     *通过药品助记码进行药品搜索
     */
    List<DrugPO> searchdrug(String code);

    /**
     *获取处方模板列表
     */
    List<PrescriptionTemplate> getPrescriptionTemplateList();

    /**
     *获取处方明细模板
     */
    List<PrescriptionDetail> getPrescriptionDetail(Integer id);

    /**
     *获取疾病分类
     */
    List<IllnessCata> getIllnessCata();

    /**
     *根据疾病分类
     */
    List<Ill> searchIll(Integer cataid);

    /**
     *增加初诊信息
     */
    boolean addFirstDiagnose(DiagnoseVO diagnoseVO);

    /**
     *根据病历号和挂号id获取诊断信息
     */
    List<DiagnosePO> getDiagnose(Integer medicalrecordid, Integer registid);

    /**
     *诊断完毕
     */
    boolean finishdiagnose(Object registid);

    /**
     *更新门诊病历首页
     */
    Integer coverMedicalMainPage(MedicalMainPage medicalMainPage);
}
