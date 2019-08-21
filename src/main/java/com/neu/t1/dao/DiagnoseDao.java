package com.neu.t1.dao;

import com.neu.t1.po.*;
import com.neu.t1.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DiagnoseDao {

    List<Map<String, Object>> getPatientList(@Param("docName") String docName);

    void submitMedicalMainPage(@Param("mainPage") MedicalMainPage mainPage);

    void changeStatus(@Param("registid") Integer registid);

    void addPrescription(@Param("prescription") Prescription prescription);

    Integer getMaxPrescriptionID();

    void filldetail(@Param("prescriptiondetail") PrescriptionDetailVO prescriptionDetailVO);

    void cancel(@Param("cancel") CancelVO cancelVO);

    List<DrugPO> searchdrug(@Param("code") String code);

    Integer getDocID(@Param("docname") String docid);

    List<PrescriptionTemplate> getPrescriptionTemplateList();

    List<PrescriptionDetail> getPrescriptionDetail(@Param("id") Integer id);

    List<IllnessCata> getIllnessCata();

    List<Ill> searchIll(@Param("cataid") Integer cataid);

    void addFirstDiagnose(@Param("diagnose") DiagnoseVO diagnoseVO);

    List<DiagnosePO> getDiagnose(@Param("medicalrecordid") Integer medicalrecordid,@Param("registid") Integer registid);

    Integer finishdiagnose(@Param("registid") String toString);

    Integer findDup(@Param("registid") Integer registid,@Param("medicalrecordid") Integer medicalrecordid);

    void deleteFirstDiagnose(@Param("registid") Integer registid,@Param("medicalrecordid") Integer medicalrecordid);

    Integer coverMedicalMainPage(@Param("mainPage") MedicalMainPage medicalMainPage);
}
