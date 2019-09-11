package com.neu.t1.po;

import lombok.Data;

/**
 *挂号信息
 */
@Data
public class RegistMsg {

    /**
     *挂号id
     */
    Integer registid;

    /**
     *病历号
     */
    Integer medicalrecordid;

    /**
     *姓名
     */
    String name;

    /**
     *身份证号
     */
    String idnumber;

    /**
     *挂号日期
     */
    String date;

    /**
     *挂号午别
     */
    String apm;

    /**
     *挂号科室id
     */
    String dep;

    /**
     *就诊状态
     */
    String diagnosestate;
}
