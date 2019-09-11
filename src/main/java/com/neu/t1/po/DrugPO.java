package com.neu.t1.po;

import lombok.Data;

/**
 *药品实体
 */
@Data
public class DrugPO {

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
    Integer drugfee;

    /**
     *药品编码
     */
    String code;
}
