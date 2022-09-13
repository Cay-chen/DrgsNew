package com.syy.chen.dao.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.syy.chen.Utils;
import com.syy.chen.YinHaiUtil;
import com.syy.chen.bean.yinhai.BackResult9001Bean;
import com.syy.chen.bean.yinhai.Input9001Bean;
import com.syy.chen.bean.yinhai.Input9001SignIn;
import com.syy.chen.bean.yinhai.YinHaiDataBean;
import com.syy.chen.dao.YinHaiDao;

import java.text.SimpleDateFormat;

public class YinHaiDaoImpl implements YinHaiDao {
    @Override
    public String getSingNo(int pt) throws Exception {
        System.out.println(pt);
        Input9001Bean input9001Bean = new Input9001Bean();
        Input9001SignIn input9001SignIn = new Input9001SignIn(Utils.getIpAddressInWindows(),Utils.getLocalMac(),"001506");
        input9001Bean.setSingIn(input9001SignIn);
        String mdtrtareaAdmvs ="510100";
        if (pt==2){
            mdtrtareaAdmvs="519900";
        }
        String input = YinHaiUpload("9001","",mdtrtareaAdmvs,"",input9001Bean);
        String backResult =YinHaiUtil.Api(input,pt);
        BackResult9001Bean backResult9001Bean;
        Gson gson = new Gson();
        backResult9001Bean =gson.fromJson(backResult, BackResult9001Bean.class);
        System.out.println(backResult9001Bean.toString());
        return backResult9001Bean.getOutput().getSigninoutb().getSign_no();
    }

    @Override
    public String upLoad(Object input,String jyNo,String signNo,String insuplcAdmdvs,int pt) throws Exception {
        String mdtrtareaAdmvs ="510100";
        if (pt==2){
            mdtrtareaAdmvs="519900";
        }
        String inputData =YinHaiUpload(jyNo,signNo,mdtrtareaAdmvs,insuplcAdmdvs,input);
        return inputData;
    }
    private String YinHaiUpload(String jyNO,String singNo,String mdtrtareaAdmvs,String insuplcAdmdvs,Object input){
        String FixmedinsCode ="H51010501809";
        String FixmedinsName ="四川省人民医院";
        String RecerSysCode = "DRHIS";
        String Infver = "V1.0";
        String OpterType = "1";
        String Opter="001506";
        String OpterName="王毕华";
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String MsgId =FixmedinsCode+df.format(System.currentTimeMillis())+(int)((Math.random()*9+1)*1000);
        YinHaiDataBean dataBean = new YinHaiDataBean();
        dataBean.setInfno(jyNO);
        dataBean.setMsgid(MsgId);
        dataBean.setMdtrtarea_admvs(mdtrtareaAdmvs);
        dataBean.setInsuplc_admdvs(insuplcAdmdvs);
        dataBean.setRecer_sys_code(RecerSysCode);
        dataBean.setDev_no("");
        dataBean.setDev_safe_info("");
        dataBean.setCainfo("");
        dataBean.setSigntype("");
        dataBean.setInfver(Infver);
        dataBean.setOpter_type(OpterType);
        dataBean.setOpter(Opter);
        dataBean.setOpter_name(OpterName);
        dataBean.setInf_time(Utils.GetNowTime());
        dataBean.setFixmedins_code(FixmedinsCode);
        dataBean.setFixmedins_name(FixmedinsName);
        dataBean.setSign_no(singNo);
        dataBean.setInput(input);
        Gson gson = new GsonBuilder().serializeNulls().create();;
        return gson.toJson(dataBean);

    }

}
