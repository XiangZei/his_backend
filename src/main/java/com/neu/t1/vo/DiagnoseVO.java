package com.neu.t1.vo;

import lombok.Data;

/**
 * 诊断信息
 */
@Data
public class DiagnoseVO {
    Integer illid;//疾病id
    Integer diagnosetype;//诊断类型
    Integer finaldiagnose;//确诊号（1 待诊 2 已诊 3 诊毕）
    Integer medicalrecordid;//病历号
    Integer registid;//挂号id
    String diagnosetime;//诊断时间
}
