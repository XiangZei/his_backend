package com.neu.t1.vo;

import lombok.Data;

//registid:this.patient.registid,
//        medicalrecordid:this.patient.medicalrecordid,
//        chiefcomplaint:"",
//        histofpresill:"",
//        treatofpresill:"",
//        pasthist:"",
//        allergichist:"",
//        physexamination:"",
//        checkresult:""

@Data
public class MedicalMainPage {
    Integer registid;
    Integer medicalrecordid;
    String chiefcomplaint;
    String histofpresill;
    String treatofpresill;
    String pasthist;
    String allergichist;
    String physicalexamination;
    String attention;
    String examsuggestion;
}
