package com.neu.t1.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RegRequireVo {
    List<Map<String,Object>> gender;
    List<Map<String,Object>> regType;
    List<Map<String,Object>> depMsg;
    List<Map<String,Object>> medicalNum;
    List<Map<String,Object>> chargeType;
}