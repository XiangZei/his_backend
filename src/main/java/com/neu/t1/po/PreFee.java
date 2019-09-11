package com.neu.t1.po;

import lombok.Data;

/**
 *处方费用实体
 */
@Data
public class PreFee {
    /**
     *药品费用
     */
    double drugfee;

    /**
     *药品数量
     */
    Integer drugnum;
}
