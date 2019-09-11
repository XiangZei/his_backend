package com.neu.t1.vo;

import lombok.Data;

/**
 * 诊断信息
 */
@Data
public class DiagnoseVO {

    /**
     *疾病id
     */
    Integer illid;

    /**
     *诊断类型
     */
    Integer diagnosetype;

    /**
     * 确诊号（1 待诊 2 已诊 3 诊毕）
     */
    Integer finaldiagnose;

    /**
     * 病历号
     */
    Integer medicalrecordid;

    /**
     *挂号id
     */
    Integer registid;

    /**
     * 诊断时间
     */
    String diagnosetime;
}
