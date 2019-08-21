package com.neu.t1.po;

import lombok.Data;

@Data
public class PrescriptionPO {
    Integer prescriptionID;
    Integer registID;
    Integer docID;
    String medicalrecordname;
    String createtime;
    Integer departmentid;
}
