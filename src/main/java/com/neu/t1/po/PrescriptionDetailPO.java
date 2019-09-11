package com.neu.t1.po;

import lombok.Data;

/**
 *处方明细
 */
@Data
public class PrescriptionDetailPO {
    /**
     * 病历号
     */
    Integer medicalrecordid;

    /**
     *处方名称
     */
    String proname;

    /**
     *药品单价
     */
    double fee;

    /**
     *药品数量
     */
    Integer num;

    /**
     *创建时间
     */
    String createtime;

    /**
     *处方明细状态
     */
    String status;

    /**
     *所属科室id
     */
    Integer depid;

    /**
     *开立医生id
     */
    Integer docid;

    /**
     *处方id
     */
    Integer prescriptionid;

    /**
     *病人挂号id
     */
    Integer registid;

    /**
     * 处方明细ID 可以为以后处方缴费，和处方明细缴费做下伏笔
     */
    Integer pdi;

    /**
     * 药品名称
     */
    String drugname;
}
