package com.neu.t1.vo;


import lombok.Data;

/**
 *处方
 */
@Data
public class Prescription {

    /**
     *处方id
     */
    Integer prescriptionid = 0;

    /**
     *病历号
     */
    Integer medicalrecordid;

    /**
     *挂号id
     */
    Integer registid;

    /**
     *医生用户名
     */
    String docid;

    /**
     * 处方名称
     */
    String medicalrecordname;

    /**
     *创建时间
     */
    String createtime;

    /**
     *处方状态
     */
    Integer status = 1;//已开立

    /**
     *医生id
     */
    Integer doc;
}
