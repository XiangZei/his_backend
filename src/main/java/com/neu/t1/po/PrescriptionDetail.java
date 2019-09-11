package com.neu.t1.po;

import lombok.Data;

/**
 *处方明细
 */
@Data
public class PrescriptionDetail {
    /**
     *药品id
     */
    Integer drugid;

    /**
     *药品名称
     */
    String drugname;

    /**
     *药品规格
     */
    String drugstd;

    /**
     *药品单价
     */
    double drugfee;

    /**
     *药品用法
     */
    String usage;

    /**
     *药品用量
     */
    String uselevel;

    /**
     *药品使用频次
     */
    String freq;
}
