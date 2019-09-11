package com.neu.t1.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;


import java.util.Date;

/**
 *挂号功能需要的信息(从前端返回并在后端接收)
 */
@Data
public class RegReturnVo {

    /**
     *挂号id
     */
    @JSONField(ordinal = 0)
    Integer regNum;

    /**
     *病历号
     */
    @JSONField(ordinal = 1)
    Integer medicalNum;//

    /**
     *姓名
     */
    @JSONField(ordinal = 2)
    String name;//

    /**
     *性别
     */
    @JSONField(ordinal = 3)
    Integer gender;//

    /**
     *年龄（直接从前端算完传到后端）
     */
    @JSONField(ordinal = 4)
    int age;//

    /**
     *年龄类型
     */
    @JSONField(ordinal = 5)
    String ageType;//

    /**
     *生日
     */
    @JSONField(format = "yyyy-MM-dd ", ordinal = 6)
    Date birthday;//

    /**
     *身份证号
     */
    @JSONField(ordinal = 7)
    String idNumber;//

    /**
     *地址
     */
    @JSONField(ordinal = 8)
    String address;//

    /**
     *结算类别
     */
    @JSONField(ordinal = 9)
    String settlementType;//

    /**
     *挂号时间
     */
    @JSONField(ordinal = 10)
    Date date1;//

    /**
     *挂号午别
     */
    @JSONField(ordinal = 11)
    String apm;//

    /**
     * 科室名称
     */
    @JSONField(ordinal = 12)
    Integer depName;//

    /**
     *挂号类别
     */
    @JSONField(ordinal = 13)
    String regType;//

    /**
     *医生姓名
     */
    @JSONField(ordinal = 14)
    Integer docName;//

    /**
     *初始号额
     */
    @JSONField(ordinal = 15)
    int initialNum;//

    /**
     * 剩余号额
     */
    @JSONField(ordinal = 16)
    int left;//

    /**
     * 病历号
     */
    @JSONField(ordinal = 17)
    String medicalRecord;//

    /**
     *挂号费用
     */
    @JSONField(ordinal = 18)
    double fee;//

    /**
     *收费类型
     */
    @JSONField(ordinal = 19)
    Integer chargeType;//

    /**
     *发票号
     */
    @JSONField(ordinal = 20)
    Integer invoiceNum;

    /**
     *挂号员id
     */
    Integer registor;

    /**
     *病历本要否
     */
    Integer medicalRecorddd;
}
