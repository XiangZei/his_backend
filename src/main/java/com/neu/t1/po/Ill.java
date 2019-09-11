package com.neu.t1.po;

import lombok.Data;

/**
 *疾病信息
 */
@Data
public class Ill {
    /**
     *疾病助记码
     */
    String illcode;

    /**
     *疾病名称
     */
    String illname;

    /**
     *药品 icd编码
     */
    String icdcode;

    /**
     *疾病id
     */
    Integer illid;
}
