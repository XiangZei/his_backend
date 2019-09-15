package com.neu.t1.controller;

import com.alibaba.fastjson.JSONObject;
import com.neu.t1.Service.DiagnoseService;
import com.neu.t1.util.CommonResult;
import com.neu.t1.po.*;
import com.neu.t1.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 医生看诊api实现
 */
@Controller
@Api(tags = "diagnose",description = "医生看诊")
@RequestMapping("/diagnose")
public class Diagnose {
    @Autowired
    DiagnoseService diagnoseService;

    /**
     *获取指定医生下的病人列表，需要提供医生的用户名
     */
    @ApiOperation(value = "获取指定医生下的病人列表，需要提供医生的用户名")
    @RequestMapping(value = "/getPatientList",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getPatientList(@RequestParam("docid")String docName){
        List<Map<String,Object>> patientlist = diagnoseService.getPatientList(docName);
        return CommonResult.success(patientlist);
    }

    /**
     *提交病历首页内容
     */
    @ApiOperation(value="提交病历首页内容")
    @RequestMapping(value = "/submitMedicalMainPage",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult submitMedicalMainPage(@RequestBody MedicalMainPage mainPage){
        if(diagnoseService.submitMedicalMainPage(mainPage))
        return CommonResult.success(1);
        return CommonResult.success(2);
    }

    /**
     *处理病人诊毕信息，需要提交病人挂号id
     */
    @ApiOperation(value="处理病人诊毕信息，需要提交病人挂号id")
    @RequestMapping(value = "/changeStatus",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult changeStatus(@RequestBody Map<String,Integer> ob){
        Integer a = ob.get("registid");

        diagnoseService.changeStatus(a);
        return CommonResult.success(null);
    }

    /**
     * 增加处方信息
     */
    @ApiOperation("增加处方信息")
    @RequestMapping(value = "/addPrescription",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addPrescription(@RequestBody Prescription prescription){
        Integer prescriptionid = diagnoseService.addPrescription(prescription);
        System.out.println(prescription.getRegistid()+"     "+prescription.getMedicalrecordid());
        if(prescriptionid==null){
            return CommonResult.failed();
        }
        Map<String ,Object> map = new HashMap<>();
        map.put("id",prescriptionid);
        return CommonResult.success(map);
    }

    /**
     * 增加处方明细
     */
    @ApiOperation(value="增加处方明细")
    @RequestMapping(value = "/filldetail",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult filldetail(@RequestBody PrescriptionDetailVO prescriptionDetailVO){
        if(diagnoseService.filldetail(prescriptionDetailVO)){
           return  CommonResult.success(null);
        }
        return CommonResult.failed("处方处理错误");
    }

    /**
     * 废除处方信息
     */
    @ApiOperation(value="废除处方信息")
    @RequestMapping(value = "/cancel",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancel(@RequestBody CancelVO cancelVO){
        if(diagnoseService.cancel(cancelVO)){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    /**
     * 搜索药品信息（使用模糊查询）
     * */
    @ApiOperation(value="搜索药品信息")
    @RequestMapping(value = "/searchdrug",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult searchdrug(@RequestParam("code")String code){
        List<DrugPO> drugPOList = diagnoseService.searchdrug(code);
        return CommonResult.success(drugPOList);
    }

    /**
     * 获取处方模板
     */
    @ApiOperation(value = "获取处方模板")
    @RequestMapping(value = "/getPrescriptionTemplateList",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getPrescriptionTemplateList(){
        List<PrescriptionTemplate> list = diagnoseService.getPrescriptionTemplateList();
        return CommonResult.success(list);
    }

    /**
     * 获取处方模板明细
     * */
    @ApiOperation(value="获取处方模板明细")
    @RequestMapping(value = "/getPrescriptionDetail",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getPrescriptionDetail(@RequestParam("id")Integer id){
        List<PrescriptionDetail> list = diagnoseService.getPrescriptionDetail(id);
        return CommonResult.success(list);
    }

    /**
     * 获取疾病分类
     */
    @ApiOperation(value="获取疾病分类")
    @RequestMapping(value = "/getIllnessCata",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getIllnessCata(){
        List<IllnessCata> list = diagnoseService.getIllnessCata();
        return CommonResult.success(list);
    }

    /**
     * 根据疾病分类获取疾病信息
     */
    @ApiOperation(value="获取疾病信息")
    @RequestMapping(value = "/searchill",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult searchill(@RequestParam("cataid")String cataid){
        Integer a = 0;
        try{
            a = Integer.parseInt(cataid);
            List<Ill> list = diagnoseService.searchIll(a);
            return CommonResult.success(list);
        }catch(Exception ex){
            return CommonResult.failed("格式转换错误");
        }
    }

    /**
     * 增加初诊信息
     */
    @ApiOperation(value="增加初诊信息")
    @RequestMapping(value = "/addFirstDiagnose",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addFirstDiagnose(@RequestBody DiagnoseVO diagnoseVO){
        if(diagnoseService.addFirstDiagnose(diagnoseVO)){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    /**
     * 根据病人信息获取病人的诊断信息
     */
    @ApiOperation(value="根据病人信息获取病人的诊断信息")
    @RequestMapping(value = "/getDiagnose",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getDiagnose(@RequestBody Map<String,Integer> patientmsg){
        List<DiagnosePO> list = diagnoseService.getDiagnose(patientmsg.get("medicalrecordid"),patientmsg.get("registid"));
        return CommonResult.success(list);
    }

    /**
     * 诊毕
     */
    @ApiOperation(value="诊毕")
    @RequestMapping(value = "/finishdiagnose",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult finishdiagnose(@RequestBody JSONObject registID){
        boolean ok = diagnoseService.finishdiagnose(registID.get("registid"));
        return ok? CommonResult.success("病人已诊毕"):CommonResult.failed();
    }

    /**
     * 更新病人病历信息
     */
    @ApiOperation(value="更新病人病历信息")
    @RequestMapping(value = "/coverMedicalMainPage",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult coverMedicalMainPage(@RequestBody MedicalMainPage medicalMainPage){
        if(diagnoseService.coverMedicalMainPage(medicalMainPage)!=null){
            return CommonResult.success("成功更新病历信息");
        }
        return CommonResult.failed();
    }
}
