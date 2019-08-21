package com.neu.t1.po;

import lombok.Data;

@Data
public class RegistMsg {
    Integer registid;
    Integer medicalrecordid;
    String name;
    String idnumber;
    String date;
    String apm;
    String dep;
    String diagnosestate;
}
