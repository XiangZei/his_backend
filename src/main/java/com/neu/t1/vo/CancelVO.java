package com.neu.t1.vo;

import lombok.Data;

/*
作废时，前端传给后端的数据
 */
@Data
public class CancelVO {

    /**
     *处方名称
     */
    String prescriptionname;

    /**
     *挂号id
     */
    Integer registid;

    /**
     *病历号
     */
    Integer medicalrecordid;

    /**
     *处方状态
     */
    Integer status;
}
