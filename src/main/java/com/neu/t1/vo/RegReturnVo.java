package com.neu.t1.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;


import java.util.Date;

@Data
public class RegReturnVo {
    @JSONField(ordinal = 0)
    Integer regNum;
    @JSONField(ordinal = 1)
    Integer medicalNum;//
    @JSONField(ordinal = 2)
    String name;//
    @JSONField(ordinal = 3)
    Integer gender;//
    //直接从前端算完传到后端
    @JSONField(ordinal = 4)
    int age;//
    @JSONField(ordinal = 5)
    String ageType;//
    @JSONField(format = "yyyy-MM-dd ", ordinal = 6)
    Date birthday;//
    @JSONField(ordinal = 7)
    String idNumber;//
    @JSONField(ordinal = 8)
    String address;//
    @JSONField(ordinal = 9)
    String settlementType;//
    @JSONField(ordinal = 10)
    Date date1;//
    @JSONField(ordinal = 11)
    String apm;//
    @JSONField(ordinal = 12)
    Integer depName;//
    @JSONField(ordinal = 13)
    String regType;//
    @JSONField(ordinal = 14)
    Integer docName;//
    @JSONField(ordinal = 15)
    int initialNum;//
    @JSONField(ordinal = 16)
    int left;//
    @JSONField(ordinal = 17)
    String medicalRecord;//
    @JSONField(ordinal = 18)
    double fee;//
    @JSONField(ordinal = 19)
    Integer chargeType;//
    @JSONField(ordinal = 20)
    Integer invoiceNum;
    Integer registor;
    Integer medicalRecorddd;
}
