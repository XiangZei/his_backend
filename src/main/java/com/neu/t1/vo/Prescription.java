package com.neu.t1.vo;


import lombok.Data;

@Data
public class Prescription {
    Integer prescriptionid = 0;
    Integer medicalrecordid;
    Integer registid;
    String docid;
    String medicalrecordname;
    String createtime;
    Integer status = 1;//已开立
    Integer doc;
}
