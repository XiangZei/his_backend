package com.neu.t1.vo;

import lombok.Data;

/**
 *发票信息
 */
@Data
public class InvoiceVO {

    /**
     *发票号
     */
    Integer invoicenum;

    /**
     *发票费用
     */
    double invoicefee;

    /**
     * 发票id
     */
    Integer invoicevalid;

    /**
     * 开立时间
     */
    String time;

    /**
     *开立人员id
     */
    String personid;

    /**
     *挂号id
     */
    Integer registid;

    /**
     *收费类型
     */
    Integer chargetype;

    /**
     *冲红发票号
     */
    String rushredinvoice;

    /**
     *发票状态
     */
    Integer invoicestate;

    /**
     *开立人员名称
     */
    Integer personname;
}
