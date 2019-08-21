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
    实现挂号，获取病历号，获取挂号信息
     */

    Map<String,Object> registrate(RegReturnVo regReturnVo);

    List<Map<String, Object>> getDocList(Integer depName, Integer regType);

    RegRequireVo getRegRequire();

    Map<String, Object> getPatientMsg(Integer medicalNum);

    Integer getLeft(Integer docNum);

    List<RegistMsg> getRegistMsg(Integer medicalrecordid);

    boolean withdrawRegis(Integer registid);

    List<PayType> getPayType();

    double feeSettlement(SettlementVO settlementVO);

    void settlement(SettlementVO settlementVO);

    List<PrescriptionDetailPO> getPreMsg(Integer medicalrecordid);

    boolean Settlement(CostDetailVO costDetailVO);

    boolean startinvoice(InvoiceVO invoiceVO);

    void distributemedicine(String pdi);

    List<PrescriptionDetailPO> getPreMsgMedicine(Integer medicalrecordid);
}
