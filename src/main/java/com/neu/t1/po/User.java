package com.neu.t1.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer userId;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "真实姓名")
    private String relname;
    @ApiModelProperty(value = "用户类型")
    private Integer userType;
    @ApiModelProperty(value = "职称")
    private Integer titleId;
    @ApiModelProperty(value = "是否参加排班")
    private String scheduling;
    @ApiModelProperty(value = "部门ID")
    private Integer depNo;
    @ApiModelProperty(value = "挂号级别")
    private Integer  regLev;
    @ApiModelProperty(value = "删除标记")
    private Integer tag;



}
