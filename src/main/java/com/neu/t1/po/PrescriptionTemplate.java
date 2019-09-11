package com.neu.t1.po;

import lombok.Data;

/**
 *处方模板
 */
@Data
public class PrescriptionTemplate {

    /**
     *处方模板id
     */
    Integer prescriptiontemplateid;

    /**
     *处方名称
     */
    String name;

    /**
     *适用范围
     */
    String scope;
}
