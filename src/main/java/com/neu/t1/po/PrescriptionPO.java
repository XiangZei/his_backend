package com.neu.t1.po;

import lombok.Data;

/**
 * 处方实体
 */
@Data
public class PrescriptionPO {

    /**
     *处方id
     */
    Integer prescriptionID;

    /**
     *挂号id
     */
    Integer registID;

    /**
     *医生id
     */
    Integer docID;

    /**
     *处方名称
     */
    String medicalrecordname;

    /**
     *创建时间
     */
    String createtime;

    /**
     *科室id
     */
    Integer departmentid;
}
