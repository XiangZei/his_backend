package com.neu.t1.po;

import lombok.Data;

@Data
public class CostDetail {
    Integer registid;//
    Integer proid;//
    Integer protype;//后期可以根据处方中的医生进行获取
    String proname;//
    double profee;
    Integer quantity;
    Integer depid;//
    String starttime;//
    Integer startPersonID;//
    String chargtime;//从外面获取
    Integer chargPersonID;//从settlementvo中获取
    Integer chargType;//从外面传进来
}
