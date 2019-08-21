package com.neu.t1.po;

import lombok.Data;

@Data

public class PrescriptionDetail {
    Integer drugid;
    String drugname;
    String drugstd;
    double drugfee;
    String usage;
    String uselevel;
    String freq;
}
