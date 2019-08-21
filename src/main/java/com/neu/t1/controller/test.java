package com.neu.t1.controller;

import com.neu.t1.component.CommonResult;
import com.neu.t1.vo.RegRequireVo;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("test")
public class test {
    @RequestMapping(value = "/getMap",consumes = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult get(@RequestBody RegRequireVo r2){
        regMsgVO1 r1 = new regMsgVO1();
        Map<String,Object> map = new HashMap<>();
        map.put("label","男");
        map.put("index",71);
        Map<String,Object> map1 = new HashMap<>();
        map1.put("label","女");
        map1.put("index",72);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("label","心血管内科");
        map2.put("index",28);
        Map<String,Object> map3 = new HashMap<>();
        map2.put("label","破伤风外科");
        map2.put("index",30);
        System.out.println(r2.toString());
        Map<String,Object> map4 = new HashMap<>();
        map4.put("label","李医生");
        map4.put("index",1);
        Map<String,Object> map7 = new HashMap<>();
        map7.put("label","赵医生");
        map7.put("index",2);
        Map<String,Object> map5  =new HashMap<>();
        map5.put("label","专家号");
        map5.put("index",1);
        Map<String,Object> map6 = new HashMap<>();
        map6.put("label","普通号");
        map6.put("index",2);
        r1.setGender(Arrays.asList(map,map1));
        r1.setDepMsg(Arrays.asList(map2,map3));
        r1.setDocList(Arrays.asList(map4,map7));
        r1.setRegType(Arrays.asList(map6,map5));

        return CommonResult.success(r1);
    }
    @Data
    private class regMsgVO{
        List<Object> gender;
        List<Object> regType;
        List<Object> depMsg;
        List<Object> docList;
    }
    @Data
    private class regMsgVO1{
        List<Map<String,Object>> gender;
        List<Map<String,Object>> regType;
        List<Map<String,Object>> depMsg;
        List<Map<String,Object>> docList;
    }

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
