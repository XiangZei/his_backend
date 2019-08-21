package com.neu.t1.po;

import lombok.Data;

@Data
public class PrescriptionDetailPO {
    Integer medicalrecordid;
    String proname;
    double fee;
    Integer num;
    String createtime;
    String status;
    Integer depid;
    Integer docid;
    Integer prescriptionid;
    Integer registid;
    //处方明细ID 可以为以后处方缴费，和处方明细缴费做下伏笔
    Integer pdi;
    String drugname;
}
