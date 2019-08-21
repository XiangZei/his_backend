package com.neu.t1.controller;

import com.alibaba.fastjson.JSONObject;
import com.neu.t1.Service.DiagnoseService;
import com.neu.t1.component.CommonResult;
import com.neu.t1.po.*;
import com.neu.t1.vo.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "diagnose",description = "医生看诊")
@RequestMapping("/diagnose")
public class Diagnose {
    @Autowired
    DiagnoseService diagnoseService;
    @RequestMapping(value = "/getPatientList",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getPatientList(@RequestParam("docid")String docName){
        List<Map<String,Object>> patientlist = diagnoseService.getPatientList(docName);
        return CommonResult.success(patientlist);
    }

    @RequestMapping(value = "/submitMedicalMainPage",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult submitMedicalMainPage(@RequestBody MedicalMainPage mainPage){
        if(diagnoseService.submitMedicalMainPage(mainPage))
        return CommonResult.success(1);
        return CommonResult.success(2);
    }

    @RequestMapping(value = "/changeStatus",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult changeStatus(@RequestBody Map<String,Integer> ob){
        Integer a = ob.get("registid");

        diagnoseService.changeStatus(a);
        return CommonResult.success(null);
    }

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

    @RequestMapping(value = "/filldetail",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult filldetail(@RequestBody PrescriptionDetailVO prescriptionDetailVO){
        if(diagnoseService.filldetail(prescriptionDetailVO)){
           return  CommonResult.success(null);
        }
        return CommonResult.failed("处方处理错误");
    }

    @RequestMapping(value = "/cancel",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancel(@RequestBody CancelVO cancelVO){
        if(diagnoseService.cancel(cancelVO)){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @RequestMapping(value = "/searchdrug",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult searchdrug(@RequestParam("code")String code){
        List<DrugPO> drugPOList = diagnoseService.searchdrug(code);
        return CommonResult.success(drugPOList);
    }

    @RequestMapping(value = "/getPrescriptionTemplateList",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getPrescriptionTemplateList(){
        List<PrescriptionTemplate> list = diagnoseService.getPrescriptionTemplateList();
        return CommonResult.success(list);
    }

    @RequestMapping(value = "/getPrescriptionDetail",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getPrescriptionDetail(@RequestParam("id")Integer id){
        List<PrescriptionDetail> list = diagnoseService.getPrescriptionDetail(id);
        return CommonResult.success(list);
    }

    @RequestMapping(value = "/getIllnessCata",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getIllnessCata(){
        List<IllnessCata> list = diagnoseService.getIllnessCata();
        return CommonResult.success(list);
    }

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

    @RequestMapping(value = "/addFirstDiagnose",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addFirstDiagnose(@RequestBody DiagnoseVO diagnoseVO){
        if(diagnoseService.addFirstDiagnose(diagnoseVO)){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @RequestMapping(value = "/getDiagnose",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getDiagnose(@RequestBody Map<String,Integer> patientmsg){
        List<DiagnosePO> list = diagnoseService.getDiagnose(patientmsg.get("medicalrecordid"),patientmsg.get("registid"));
        return CommonResult.success(list);
    }

    @RequestMapping(value = "/finishdiagnose",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult finishdiagnose(@RequestBody JSONObject registID){
        boolean ok = diagnoseService.finishdiagnose(registID.get("registid"));
        return ok? CommonResult.success("病人已诊毕"):CommonResult.failed();
    }

    @RequestMapping(value = "/coverMedicalMainPage",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult coverMedicalMainPage(@RequestBody MedicalMainPage medicalMainPage){
        if(diagnoseService.coverMedicalMainPage(medicalMainPage)!=null){
            return CommonResult.success("成功更新病历信息");
        }
        return CommonResult.failed();
    }
}
