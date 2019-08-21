package com.neu.t1.vo;

import lombok.Data;

@Data
public class SettlementVO {
    Integer registid;
    Integer medicalrecordid;
    String docid;
    String createtime;
    Integer chargetype;
    Integer invoicenum;
}
