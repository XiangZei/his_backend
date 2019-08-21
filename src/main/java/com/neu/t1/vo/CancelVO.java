package com.neu.t1.vo;

import lombok.Data;

/*
作废时，前端传给后端的数据
 */
@Data
public class CancelVO {
    String prescriptionname;
    Integer registid;
    Integer medicalrecordid;
    Integer status;
}
