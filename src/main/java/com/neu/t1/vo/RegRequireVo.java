package com.neu.t1.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 挂号初始的信息
 */
@Data
public class RegRequireVo {

    /**
     *性别信息
     */
    List<Map<String,Object>> gender;

    /**
     *挂号类型
     */
    List<Map<String,Object>> regType;

    /**
     * 科室信息
     */
    List<Map<String,Object>> depMsg;

    /**
     * 病历号列表
     */
    List<Map<String,Object>> medicalNum;

    /**
     *收费类型
     */
    List<Map<String,Object>> chargeType;
}