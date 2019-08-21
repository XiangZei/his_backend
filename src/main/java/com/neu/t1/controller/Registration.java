package com.neu.t1.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neu.t1.Service.RegistrationService;
import com.neu.t1.component.CommonResult;
import com.neu.t1.po.PayType;
import com.neu.t1.po.PrescriptionDetailPO;
import com.neu.t1.po.PrescriptionPO;
import com.neu.t1.po.RegistMsg;
import com.neu.t1.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "registration" ,description = "挂号处理")
@RequestMapping("/registration")
public class Registration {
    /*
    1 生成病历号 generateMedicalRecord -> RegistrationDao
     */
    @Autowired
    RegistrationService registrationService;

    @ApiOperation("根据科室名称和挂号级别获取医生列表")
    @GetMapping("/getDocList")
    @ResponseBody
    public CommonResult getDocList(@RequestParam(value = "depName",required = true) Integer depName,
                                           @RequestParam(value = "regType",required = true) Integer regType){
        System.out.println("获取医生列表");
        List<Map<String,Object>> docList= registrationService.getDocList(depName,regType);
        if(docList==null){
            return CommonResult.failed("科室或挂号信息有误，请重新提交");
        }
        return CommonResult.success(docList);
    }

    @ApiOperation("初始化的时候直接获取挂号类别和科室信息")
    @GetMapping("/getRequireMsg")
    @ResponseBody
    public CommonResult getRequireMsg(){
        System.out.println("获取必要初始化信息");
        RegRequireVo r = registrationService.getRegRequire();
        if(r==null){
            return CommonResult.failed("信息初始化失败，数据库问题，请不要疯狂点击。");
        }
        return CommonResult.success(r);
    }

    @ApiOperation("根据病历ID获取病人信息")
    @GetMapping("/getPatientMsg")
    @ResponseBody
    public CommonResult getPatientMsg(@RequestParam(value = "medicalNum")Integer medicalNum){
        System.out.println("根据病历ID获取病人信息");
        Map<String,Object> m = registrationService.getPatientMsg(medicalNum);
        if(m==null){
            return CommonResult.failed();
        }
        return CommonResult.success(m);
    }

    @ApiOperation("获取剩余号额")
    @GetMapping("/getleft")
    @ResponseBody
    public CommonResult getLeft(@RequestParam(value = "docNum")Integer docNum){
        Integer left = registrationService.getLeft(docNum);
        return CommonResult.success(left);
    }

    @ApiOperation("提交挂号信息")
    @PostMapping("/regis")
    @ResponseBody
    public CommonResult regis(@RequestBody RegReturnVo returnVo){
        Map<String,Object> m = registrationService.registrate(returnVo);
        if(m==null)
            return CommonResult.failed("挂号失败");
        return CommonResult.success(m);
    }

    @ApiOperation("获取病人挂号信息")
    @GetMapping("/getRegistMsg")
    @ResponseBody
    public CommonResult getRegistMsg(@RequestParam("medicalrecordid")Integer medicalrecordid){
        List<RegistMsg> registMsgList = registrationService.getRegistMsg(medicalrecordid);
        return CommonResult.success(registMsgList);
    }

    @ApiOperation("病人退号")
    @GetMapping("/withdrawRegis")
    @ResponseBody
    public CommonResult withdrawRegis(@RequestParam("registid")Integer registid){
        if(registrationService.withdrawRegis(registid)){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取支付方式")
    @GetMapping("/getPayType")
    @ResponseBody
    public CommonResult getPayType(){
        List<PayType> list = registrationService.getPayType();
        return CommonResult.success(list);
    }

    @ApiOperation("计算结算总费用")
    @PostMapping("/feeSettlement")
    @ResponseBody
    public CommonResult feeSettlement(@RequestBody SettlementVO settlementVO){
        Double fee = registrationService.feeSettlement(settlementVO);
        return CommonResult.success(fee);
    }

    @ApiOperation("缴费处理")
    @PostMapping("/settlement")
    @ResponseBody
    public CommonResult settlement(@RequestBody SettlementVO settlementVO){
        registrationService.settlement(settlementVO);
        return CommonResult.success(null);
    }

    @ApiOperation("获取处方信息")
    @GetMapping("/getPreMsg")
    @ResponseBody
    public CommonResult getPreMsg(@RequestParam("medicalrecordid")Integer medicalrecordid){
        List<PrescriptionDetailPO> list = registrationService.getPreMsg(medicalrecordid);
        return CommonResult.success(list);
    }

    @ApiOperation("增添缴费明细")
    @PostMapping("/Settlement")
    @ResponseBody
    public CommonResult Settlement(@RequestBody CostDetailVO costDetailVO){
        if(registrationService.Settlement(costDetailVO)){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("增添发票明细")
    @PostMapping("/startinvoice")
    @ResponseBody
    public CommonResult startinvoice(@RequestBody InvoiceVO invoiceVO){
        if(registrationService.startinvoice(invoiceVO)){
            return CommonResult.success(null);
        }else{
            return CommonResult.failed("发票号冲突");
        }

    }

    @PostMapping("/distributemedicine")
    @ResponseBody
    public CommonResult distributemedicine(@RequestBody JSONObject pdi){
        registrationService.distributemedicine(pdi.get("pdi").toString());
        return CommonResult.success(null);
    }
    @GetMapping("/getPreMsgMedicine")
    @ResponseBody
    public CommonResult getPreMsgMedicine(@RequestParam("medicalrecordid")Integer medicalrecordid){
        List<PrescriptionDetailPO> list = registrationService.getPreMsgMedicine(medicalrecordid);
        return CommonResult.success(list);
    }
}
