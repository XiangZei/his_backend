package com.neu.t1.vo;

import lombok.Data;

/**
 *门诊病历首页
 */
@Data
public class MedicalMainPage {

    /**
     *挂号id
     */
    Integer registid;

    /**
     *病历号
     */
    Integer medicalrecordid;

    /**
     *主诉
     */
    String chiefcomplaint;

    /**
     * 现病史
     */
    String histofpresill;

    /**
     * 现病治疗史
     */
    String treatofpresill;

    /**
     *既往史
     */
    String pasthist;

    /**
     *过敏史
     */
    String allergichist;

    /**
     * 物理检查
     */
    String physicalexamination;

    /**
     * 注意事项
     */
    String attention;

    /**
     * 建议意见
     */
    String examsuggestion;
}
