package com.neu.t1.vo;

import lombok.Data;

@Data
public class DiagnoseVO {
    Integer illid;
    Integer diagnosetype;
    Integer finaldiagnose;
    Integer medicalrecordid;
    Integer registid;
    String diagnosetime;
}
