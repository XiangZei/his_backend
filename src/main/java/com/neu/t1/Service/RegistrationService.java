package com.neu.t1.Service;

import com.alibaba.fastjson.JSONObject;
import com.neu.t1.po.PayType;
import com.neu.t1.po.PrescriptionDetailPO;
import com.neu.t1.po.PrescriptionPO;
import com.neu.t1.po.RegistMsg;
import com.neu.t1.vo.*;

import java.util.List;
import java.util.Map;


public interface RegistrationService {
    /*
     *实现挂号，获取病历号，获取挂号信息
     */
    Map<String,Object> registrate(RegReturnVo regReturnVo);

    /**
     * 获取医生列表
     */
    List<Map<String, Object>> getDocList(Integer depName, Integer regType);

    /**
     *获取实行挂号的必要信息
     */
    RegRequireVo getRegRequire();

    /**
     *根据病历号获取病人具体信息
     */
    Map<String, Object> getPatientMsg(Integer medicalNum);

    /**
     *获取医生剩余数量
     */
    Integer getLeft(Integer docNum);

    /**
     *根据病人病历号获取挂号信息
     */
    List<RegistMsg> getRegistMsg(Integer medicalrecordid);

    /**
     *根据挂号id进行退号
     */
    boolean withdrawRegis(Integer registid);

    /**
     *获取支付类型列表
     */
    List<PayType> getPayType();

    /**
     * 根据结算信息计算费用并且返回给前端
     */
    double feeSettlement(SettlementVO settlementVO);

    /**
     *进行费用结算
     */
    void settlement(SettlementVO settlementVO);

    /**
     *获取根据病历号病历信息
     */
    List<PrescriptionDetailPO> getPreMsg(Integer medicalrecordid);

    /**
     *根据消费明细进行结算
     */
    boolean Settlement(CostDetailVO costDetailVO);

    /**
     *开立发票
     */
    boolean startinvoice(InvoiceVO invoiceVO);

    /**
     *发药
     */
    void distributemedicine(String pdi);

    /**
     * 获取处方明细
     */
    List<PrescriptionDetailPO> getPreMsgMedicine(Integer medicalrecordid);


}
