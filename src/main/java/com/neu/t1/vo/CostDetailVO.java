package com.neu.t1.vo;

import lombok.Data;

/**
 * 处方明细
 */
@Data
public class CostDetailVO {
    /**
     *挂号id
     */
    Integer registid;

    /**
     *处方id
     */
    Integer pd;

    /**
     * 项目类型（收费类型）
     */
    Integer protype;

    /**
     *药品名称
     */
    String drugname;

    /**
     *药品单价
     */
    double fee;

    /**
     *药品数量
     */
    Integer quantity;

    /**
     * 科室id
     */
    Integer depid;

    /**
     *开立时间
     */
    String starttime;

    /**
     *开立医生id
     */
    Integer startdocid;

    /**
     *收费时间
     */
    String chargetime;

    /**
     *结算医生id
     */
    String docid;

    /**
     *支付类型
     */
    Integer paytype;

    /**
     *病历号
     */
    Integer medicalrecordid;

    /**
     *处方明细id
     */
    Integer pdi;


    /**
     *医生姓名
     */
    Integer docname;

}
