package com.neu.t1.vo;

import lombok.Data;

@Data
public class PrescriptionDetailVO {
    Integer prescriptionid;
    Integer drugid;
    String usage;
    String uselevel;
    String freq;
    Integer num;
    Integer status;
}
