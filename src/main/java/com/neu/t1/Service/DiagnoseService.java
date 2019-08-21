package com.neu.t1.Service;

import com.neu.t1.po.*;
import com.neu.t1.vo.*;

import java.util.List;
import java.util.Map;

public interface DiagnoseService {
    List<Map<String,Object>> getPatientList(String docName);

    boolean submitMedicalMainPage(MedicalMainPage mainPage);

    void changeStatus(Integer registid);

    Integer addPrescription(Prescription prescription);

    boolean filldetail(PrescriptionDetailVO prescriptionDetailVO);

    boolean cancel(CancelVO cancelVO);

    List<DrugPO> searchdrug(String code);

    List<PrescriptionTemplate> getPrescriptionTemplateList();

    List<PrescriptionDetail> getPrescriptionDetail(Integer id);

    List<IllnessCata> getIllnessCata();

    List<Ill> searchIll(Integer cataid);

    boolean addFirstDiagnose(DiagnoseVO diagnoseVO);

    List<DiagnosePO> getDiagnose(Integer medicalrecordid, Integer registid);

    boolean finishdiagnose(Object registid);

    Integer coverMedicalMainPage(MedicalMainPage medicalMainPage);
}
