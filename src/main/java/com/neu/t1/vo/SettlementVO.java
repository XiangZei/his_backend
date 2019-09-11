package com.neu.t1.vo;

import lombok.Data;

/**
 * 从前端传来的结算类
 */
@Data
public class SettlementVO {

    /**
     *挂号id
     */
    Integer registid;

    /**
     *病历号
     */
    Integer medicalrecordid;

    /**
     *医生id
     */
    String docid;

    /**
     *创建时间
     */
    String createtime;

    /**
     *收费类型
     */
    Integer chargetype;

    /**
     *发票号
     */
    Integer invoicenum;
}
