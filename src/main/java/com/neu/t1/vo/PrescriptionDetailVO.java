package com.neu.t1.vo;

import lombok.Data;

/**
 *处方明细
 */
@Data
public class PrescriptionDetailVO {

    /**
     *处方明细id
     */
    Integer prescriptionid;

    /**
     *药品id
     */
    Integer drugid;

    /**
     *用法
     */
    String usage;

    /**
     *用量
     */
    String uselevel;

    /**
     *频次
     */
    String freq;

    /**
     *数量
     */
    Integer num;

    /**
     *状态
     */
    Integer status;
}
