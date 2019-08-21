package com.neu.t1.vo;

import lombok.Data;

@Data
public class InvoiceVO {
    Integer invoicenum;
    double invoicefee;
    Integer invoicevalid;
    String time;
    String personid;
    Integer registid;
    Integer chargetype;
    String rushredinvoice;
    Integer invoicestate;
    Integer personname;
}
