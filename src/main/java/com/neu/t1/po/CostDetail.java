package com.neu.t1.po;

import lombok.Data;

/**
 *缴费明细
 */
@Data
public class CostDetail {
    Integer registid;//挂号id
    Integer proid;//项目id
    Integer protype;//后期可以根据处方中的医生进行获取
    String proname;//项目名称
    double profee;//项目费用
    Integer quantity;//数量
    Integer depid;//科室id
    String starttime;//开立时间
    Integer startPersonID;//开立人员id
    String chargtime;//收费时间
    Integer chargPersonID;//从settlementvo中获取，收费人员id
    Integer chargType;//从外面传进来
}
