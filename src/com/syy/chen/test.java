package com.syy.chen;


import com.syy.chen.dao.impl.GrabData4401DaoImpl;
import com.syy.chen.dao.impl.YinHaiDaoImpl;
import com.syy.chen.models.BaglDataTool;
import com.syy.chen.models.DrgsDataTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

    public static void main(String[] args) throws Exception {
/*        Data4101ADaoImpl data4101ADao = new Data4101ADaoImpl();
        Data4101ABean data = data4101ADao.getSetlInfo4101A("519900G0000000907392-1", "1", true);
        Gson gson = new Gson();
        System.out.println(gson.toJson(data));*/
/*        String input = "{\"infno\":\"4101A\",\"msgid\":\"H5101050180920220803154522746\",\"mdtrtarea_admvs\":\"510100\",\"insuplc_admdvs\":\"510112\",\"recer_sys_code\":\"DRHIS\",\"dev_no\":\"\",\"dev_safe_info\":\"\",\"cainfo\":\"\",\"signtype\":\"\",\"infver\":\"V1.0\",\"opter_type\":\"1\",\"opter\":\"001506\",\"opter_name\":\"王毕华\",\"inf_time\":\"2022-08-03 15:45:22\",\"fixmedins_code\":\"H51010501809\",\"fixmedins_name\":\"四川省人民医院\",\"sign_no\":\"510100CD000002399349\",\"input\":{\"setlinfo\":{\"acp_medins_name\":\"\",\"acp_optins_code\":\"\",\"adm_time\":\"\",\"adm_way\":\"\",\"bill_code\":\"-\",\"bill_no\":\"241529316\",\"biz_sn\":\"21000000004572121\",\"chfpdr_code\":\"\",\"coner_addr\":\"\",\"coner_name\":\"\",\"coner_tel\":\"\",\"curr_addr\":\"四川省成都市龙泉驿区黄土镇永丰村８组１８号\",\"days_rinp_flag_31\":\"\",\"days_rinp_pup_31\":\"\",\"dcla_time\":\"2022-01-04 15:03:28\",\"dscg_caty\":\"\",\"dscg_time\":\"\",\"dscg_way\":\"\",\"emp_addr\":\" \",\"emp_name\":\" \",\"emp_tel\":\"\",\"hi_no\":\"\",\"hi_paymtd\":\"1\",\"lv1_nurscare_days\":null,\"lv3_nurscare_days\":null,\"mdtrt_id\":\"510100CD000022803027\",\"medcasno\":\"21000000004572121\",\"medins_fill_dept\":\"\",\"medins_fill_psn\":\"\",\"ntly\":\"CN\",\"nwb_admtype\":\"\",\"nwbadmwt\":null,\"nwbbirwt\":null,\"opsp_diag_caty\":\"A19\",\"opsp_mdtrt_date\":\"2021-09-30\",\"otp_wm_dise\":\"\",\"otptcmdise\":\"\",\"patn_rlts\":\"\",\"poscode\":\"\",\"prfs\":\"12\",\"psn_no\":\"51000051010000000883349780\",\"pwcry_afadm_coma_dura\":\"\",\"pwcry_bfadm_coma_dura\":\"\",\"refldept_dept\":\"\",\"resp_nurs_code\":\"\",\"scd_nurscare_days\":null,\"setl_begn_date\":\"2022-01-04\",\"setl_end_date\":\"2022-01-04\",\"setl_id\":\"510100CD000015464321\",\"spga_nurscare_days\":null,\"stas_type\":\"\",\"tcmdisecode\":\"\",\"trt_type\":\"\",\"vent_used_dura\":\"\",\"wm_dise_code\":\"\"},\"opspdiseinfo\":[{\"diag_name\":\"帕金森病\",\"diag_code\":\"G20.x00\",\"oprn_oprt_name\":\"-\",\"oprn_oprt_code\":\"-\"},{\"diag_name\":\"原发性高血压\",\"diag_code\":\"I10.x09\",\"oprn_oprt_name\":\"-\",\"oprn_oprt_code\":\"-\"},{\"diag_name\":\"胃恶性肿瘤\",\"diag_code\":\"C16.900\",\"oprn_oprt_name\":\"-\",\"oprn_oprt_code\":\"-\"},{\"diag_name\":\"肿瘤术后免疫治疗\",\"diag_code\":\"Z51.805\",\"oprn_oprt_name\":\"-\",\"oprn_oprt_code\":\"-\"}],\"diseinfo\":null,\"oprninfo\":null,\"icuinfo\":null,\"bldinfo\":null}}";
       // System.out.println(YinHaiHttpUtil.Api(input,1));
        DrgsDataTool drgsDataTool = new DrgsDataTool();
        Connection conn =drgsDataTool.getConn();
        OperateDataDaoImpl operateDataDao = new OperateDataDaoImpl();
        //operateDataDao.InsertUploadMsg(conn,input,"1257485415715923I4","1257485415715923","2022-12-12 12:12:12","{ASDASDASDKUAYSUIDYAKJSBNDKIUASYD}","4101A",Utils.GetNowTime(),"1",2);
      //  operateDataDao.GrabDataErrMsg(conn,"1257485415715923I4","4101A","1","ORA-00001: 违反唯一约束条件 (GRDS.DATA_SETL4101)",Utils.replaceUtil("INSERT INTO DATA_4101A_SETLINFO (setl_id_main,psn_no,mdtrt_id,setl_id,hi_no,medcasno,dcla_time,ntly,prfs,curr_addr,emp_name,emp_addr,emp_tel,poscode,coner_name,patn_rlts,coner_addr,coner_tel,nwb_admtype,nwbbirwt,nwbadmwt,opsp_diag_caty,opsp_mdtrt_date,adm_way,trt_type,adm_time,refldept_dept,dscg_time,dscg_caty,otp_wm_dise,wm_dise_code,otptcmdise,tcmdisecode,vent_used_dura,pwcry_bfadm_coma_dura,pwcry_afadm_coma_dura,spga_nurscare_days,lv1_nurscare_days,scd_nurscare_days,lv3_nurscare_days,dscg_way,acp_medins_name,acp_optins_code,bill_code,bill_no,biz_sn,days_rinp_flag_31,days_rinp_pup_31,chfpdr_code,setl_begn_date,setl_end_date,medins_fill_dept,medins_fill_psn,resp_nurs_code,stas_type,hi_paymtd,type_mz,type_flag,insuplc_admdvs,pact_code,medical_type,grap_time,trans_type,invoice_no,setl_date) VALUES ( '510800G0000007387729-1','510000510800002001046712','519900Y2202281985579','510800G0000007387729',null,'2081722',to_date('2022-03-01 09:17:49', 'yyyy-MM-dd HH24:mi:ss'),'中国','80','四川省广元市旺苍县嘉川镇石龙村4组313号','-','四川省广元市旺苍县','18384128464','628000','侯国英','01','四川省广元市旺苍县','18384128464','-',0,0,null,null,'2',null,to_date('2022-02-27 10:09:00', 'yyyy-MM-dd HH24:mi:ss'),null,to_date('2022-03-01 08:40:35', 'yyyy-MM-dd HH24:mi:ss'),'A03.02','结肠息肉','K63.500',null,null,null,null,null,0,0,0,0,'1',null,'-',null,'000248844250','2081722+1','1',null,'3248',to_date('2022-03-01', 'yyyy-MM-dd'),to_date('2022-03-01', 'yyyy-MM-dd'),'-','-','3249',null,'1','2','3','510800','38','21',to_date('2022-08-05 11:31:09', 'yyyy-MM-dd HH24:mi:ss'),'1','ZY00010002081722',to_date('2022-03-01', 'yyyy-MM-dd'))"),"2022-12-12",Utils.GetNowTime());
        operateDataDao.UpdateUploadState(conn,"12547864",0,Utils.GetNowTime(),"510100CD000080892597-1",2);
        conn.close();*/

       // Utils.getIpAddressInWindows();

       // System.out.println(Utils.getLocalMac());
/*        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println( df.format(System.currentTimeMillis())+(int)((Math.random()*9+1)*1000));*/
/*         YinHaiDaoImpl yh = new YinHaiDaoImpl();
        String s =  yh.getSingNo(2);
        System.out.println(s);*/
      //  String ABC ="N2455badadadad";
        //System.out.println(ABC.substring(0,1));
       // updat();

        testUpload();

/*        DrgsDataTool drgsDataTool = new DrgsDataTool();
        Connection conn = drgsDataTool.getConn();
        BaglDataTool baglDataTool = new BaglDataTool();
        Connection baglConn = baglDataTool.getConn();
        GrabData4401DaoImpl grabData4401Dao = new GrabData4401DaoImpl();
        grabData4401Dao.getData("2022-06-09",conn,baglConn);*/
    }

    private static void updat(){
        String sql ="select nation_code from DAWN_ORG_EMPL";
        DrgsDataTool drgsDataTool = new DrgsDataTool();
        Connection connection= drgsDataTool.getConn();
        try {
            PreparedStatement ps =connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String s = rs.getString(1);
                String sql1= "update DAWN_ORG_EMPL t set t.type=? where t.nation_code=?";
                PreparedStatement ps1 = connection.prepareStatement(sql1);
                ps1.setString(1,s.substring(0,1));
                ps1.setString(2,s);
                ps1.executeQuery();
                ps1.close();
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    private static void  testUpload(){
        String intput ="{\"infno\": \"4401\",\"msgid\": \"H51010501809202209032120203713\",\"mdtrtarea_admvs\": \"510100\",\"insuplc_admdvs\": \"510112\",\"recer_sys_code\": \"DRHIS\",\"dev_no\": \"\",\"dev_safe_info\": \"\",\"cainfo\": \"\",\"signtype\": \"\",\"infver\": \"V1.0\",\"opter_type\": \"1\",\"opter\": \"001506\",\"opter_name\": \"王毕华\",\"inf_time\": \"2022-09-03 21:20:20\",\"fixmedins_code\": \"H51010501809\",\"fixmedins_name\": \"四川省人民医院\",\"sign_no\": \"510100CD000002592352\",\"input\": {  \"baseinfo\": {\"mdtrt_sn\": \"H51010501809ZY00030001469857\",\"mdtrt_id\": \"510100CD000103613764\",\"psn_no\": \"51000051010000000120113721\",\"patn_ipt_cnt\": \"3\",\"ipt_no\": \"ZY00030001469857\",\"medcasno\": \"1469857\",\"psn_name\": \"薛珠伦\",\"gend\": \"1\",\"brdy\": \"1963-10-27\",\"ntly\": \"中国\",\"ntly_name\": \"中国\",\"nwb_bir_wt\": 0.0,\"nwb_adm_wt\": 0.0,\"birplc\": \"四川省成都市龙泉驿区\",\"napl\": \"四川省成都市龙泉驿区\",\"naty_name\": \"汉族\",\"naty\": \"1\",\"certno\": \"510112196310272115\",\"prfs\": \"90\",\"mrg_stas\": \"2\",\"curr_addr_poscode\": \"610000\",\"curr_addr\": \"四川省成都市龙泉驿区大面富桥街１号１９栋３单元６号附１号\",\"psn_tel\": \"15828284431\",\"resd_addr_prov\": \"510000\",\"resd_addr_city\": \"510100\",\"resd_addr_coty\": \"510112\",\"resd_addr_subd\": \"\",\"resd_addr_vil\": \"\",\"resd_addr_housnum\": \"\",\"resd_addr_poscode\": \"610000\",\"resd_addr\": \"成都市龙泉驿区大面富桥街１号１９栋３单元６号附１号\",\"empr_tel\": \"15828284431\",\"empr_poscode\": \"610000\",\"empr_addr\": \"成都市龙泉驿区大面富桥街１号１９栋３单元６号附１号\",\"coner_tel\": \"15828284431\",\"coner_name\": \"薛尚根\",\"coner_addr\": \"成都市龙泉驿区大面富桥街１号１９栋３单元６号附１号\",\"coner_rlts_code\": \"80\",\"adm_way_name\": \"急诊\",\"adm_way_code\": \"1\",\"trt_type_name\": \"西医\",\"trt_type\": \"\",\"adm_caty\": \"A28\",\"adm_ward\": \"(东）ICU\",\"adm_date\": \"2022-05-02\",\"dscg_date\": \"2022-05-03\",\"dscg_caty\": \"A28\",\"refldeptcatyname\": \"-\",\"dscg_ward\": \"(东）ICU\",\"ipt_days\": 1,\"drug_dicm_flag\": \"1\",\"dicm_drug_name\": \"-\",\"die_autp_flag\": \"2\",\"abo_code\": \"3 \",\"abo_name\": \"O型\",\"rh_code\": \"2\",\"rh_name\": \" 阳\",\"die_flag\": \"1\",\"deptdrt_name\": \"曹小瑶\",\"chfdr_name\": \"曹小瑶\",\"atddr_name\": \"杨陈\",\"chfpdr_name\": \"刘蓉安\",\"ipt_dr_name\": \"杨陈\",\"resp_nurs_name\": \"陈秀荣\",\"train_dr_name\": \"\",\"intn_dr_name\": \"\",\"codr_name\": \"刘钦\",\"qltctrl_dr_name\": \"曹小瑶\",\"qltctrl_nurs_name\": \"龙国利\",\"medcas_qlt_name\": \"甲级\",\"medcas_qlt_code\": \"1\",\"qltctrl_date\": \"2022-05-07\",\"dscg_way_name\": \"死亡\",\"dscg_way\": \"5\",\"acp_medins_code\": \"\",\"acp_medins_name\": \"\",\"dscg_31days_rinp_flag\": \"1\",\"dscg_31days_rinp_pup\": \"\",\"damg_intx_ext_rea\": \"\",\"damg_intx_ext_rea_disecode\": \"\",\"brn_damg_bfadm_coma_dura\": \"\",\"brn_damg_afadm_coma_dura\": \"\",\"vent_used_dura\": \"\",\"cnfm_date\": \"2022-05-02\",\"patn_dise_diag_crsp\": \"-\",\"patn_dise_diag_crsp_code\": \"-\",\"ipt_patn_diag_inscp\": \"符合\",\"ipt_patn_diag_inscp_code\": \"1\",\"dscg_trt_rslt\": \"死亡\",\"dscg_trt_rslt_code\": \"4\",\"medins_orgcode\": \"\",\"age\": 58.0,\"aise\": \"\",\"pote_intn_dr_name\": \"\",\"hbsag\": \" \",\"hcvab\": \" \",\"hivab\": \" \",\"resc_cnt\": 2,\"resc_succ_cnt\": 1,\"hosp_dise_fsttime\": \"\",\"hif_pay_way_name\": \"\",\"hif_pay_way_code\": \"\",\"med_fee_paymtd_name\": \"城镇居民保险\",\"medfee_paymtd_code\": \"13\",\"selfpay_amt\": 5229.79,\"medfee_sumamt\": 22836.85,\"ordn_med_servfee\": 452.0,\"ordn_trt_oprt_fee\": 1378.0,\"nurs_fee\": 418.0,\"com_med_serv_oth_fee\": 0.0,\"palg_diag_fee\": 0.0,\"lab_diag_fee\": 2035.0,\"rdhy_diag_fee\": 480.0,\"clnc_dise_fee\": 1518.0,\"nsrgtrt_item_fee\": 676.0,\"clnc_phys_trt_fee\": 356.0,\"rgtrt_trt_fee\": 367.0,\"anst_fee\": 367.0,\"oprn_fee\": 0.0,\"rhab_fee\": 68.0,\"tcm_trt_fee\": 0.0,\"wmfee\": 13223.33,\"abtl_medn_fee\": 664.26,\"tcmpat_fee\": 393.6,\"tcmherb_fee\": 0.0,\"blo_fee\": 0.0,\"albu_fee\": 0.0,\"glon_fee\": 0.0,\"clotfac_fee\": 0.0,\"cyki_fee\": 0.0,\"exam_dspo_matl_fee\": 9.96,\"trt_dspo_matl_fee\": 1503.36,\"oprn_dspo_matl_fee\": 162.6,\"oth_fee\": 152.0,\"vali_flag\": \"1\",\"fixmedins_code\": \"H51010501809\",\"trade_serial_cds\": null,\"upload_time_cds\": null,\"upload_state_cds\": 0,\"grab_time\": null,\"inpatient_no\": null,\"type_flag\": null,\"upload_time_scs\": null,\"upload_state_scs\": 0,\"trade_serial_scs\": null,\"medical_type\": null,\"pact_code\": null,\"insuplc_admdvs\": null,\"setl_date\": null,\"upload_time\": null,\"trade_serial\": null,\"upload_state\": null  },  \"diseinfo\": [{  \"palg_no\": \"ZY00030001469857\",  \"ipt_patn_disediag_type_code\": \"\",  \"disediag_type\": \"\",  \"maindiag_flag\": \"1\",  \"diag_code\": \"J18.903\",  \"diag_name\": \"重症肺炎\",  \"inhosp_diag_code\": \"\",  \"inhosp_diag_name\": \"\",  \"adm_dise_cond_name\": \"\",  \"adm_dise_cond_code\": \"\",  \"adm_cond\": \"\",  \"adm_cond_code\": \"\",  \"high_diag_evid\": \"\",  \"bkup_deg\": \"\",  \"bkup_deg_code\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\",  \"fixmedins_code\": \"H51010501809\"},{  \"palg_no\": \"ZY00030001469857\",  \"ipt_patn_disediag_type_code\": \"\",  \"disediag_type\": \"\",  \"maindiag_flag\": \"0\",  \"diag_code\": \"A41.900x003\",  \"diag_name\": \"脓毒性休克\",  \"inhosp_diag_code\": \"\",  \"inhosp_diag_name\": \"\",  \"adm_dise_cond_name\": \"\",  \"adm_dise_cond_code\": \"\",  \"adm_cond\": \"\",  \"adm_cond_code\": \"\",  \"high_diag_evid\": \"\",  \"bkup_deg\": \"\",  \"bkup_deg_code\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\",  \"fixmedins_code\": \"H51010501809\"},{  \"palg_no\": \"ZY00030001469857\",  \"ipt_patn_disediag_type_code\": \"\",  \"disediag_type\": \"\",  \"maindiag_flag\": \"0\",  \"diag_code\": \"K70.300\",  \"diag_name\": \"酒精性肝硬化\",  \"inhosp_diag_code\": \"\",  \"inhosp_diag_name\": \"\",  \"adm_dise_cond_name\": \"\",  \"adm_dise_cond_code\": \"\",  \"adm_cond\": \"\",  \"adm_cond_code\": \"\",  \"high_diag_evid\": \"\",  \"bkup_deg\": \"\",  \"bkup_deg_code\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\",  \"fixmedins_code\": \"H51010501809\"},{  \"palg_no\": \"ZY00030001469857\",  \"ipt_patn_disediag_type_code\": \"\",  \"disediag_type\": \"\",  \"maindiag_flag\": \"0\",  \"diag_code\": \"K70.403\",  \"diag_name\": \"酒精性肝衰竭伴肝昏迷\",  \"inhosp_diag_code\": \"\",  \"inhosp_diag_name\": \"\",  \"adm_dise_cond_name\": \"\",  \"adm_dise_cond_code\": \"\",  \"adm_cond\": \"\",  \"adm_cond_code\": \"\",  \"high_diag_evid\": \"\",  \"bkup_deg\": \"\",  \"bkup_deg_code\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\",  \"fixmedins_code\": \"H51010501809\"},{  \"palg_no\": \"ZY00030001469857\",  \"ipt_patn_disediag_type_code\": \"\",  \"disediag_type\": \"\",  \"maindiag_flag\": \"0\",  \"diag_code\": \"E11.100\",  \"diag_name\": \"2型糖尿病伴有酮症酸中毒\",  \"inhosp_diag_code\": \"\",  \"inhosp_diag_name\": \"\",  \"adm_dise_cond_name\": \"\",  \"adm_dise_cond_code\": \"\",  \"adm_cond\": \"\",  \"adm_cond_code\": \"\",  \"high_diag_evid\": \"\",  \"bkup_deg\": \"\",  \"bkup_deg_code\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\",  \"fixmedins_code\": \"H51010501809\"},{  \"palg_no\": \"ZY00030001469857\",  \"ipt_patn_disediag_type_code\": \"\",  \"disediag_type\": \"\",  \"maindiag_flag\": \"0\",  \"diag_code\": \"N19.x00x002\",  \"diag_name\": \"肾功能不全\",  \"inhosp_diag_code\": \"\",  \"inhosp_diag_name\": \"\",  \"adm_dise_cond_name\": \"\",  \"adm_dise_cond_code\": \"\",  \"adm_cond\": \"\",  \"adm_cond_code\": \"\",  \"high_diag_evid\": \"\",  \"bkup_deg\": \"\",  \"bkup_deg_code\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\",  \"fixmedins_code\": \"H51010501809\"},{  \"palg_no\": \"ZY00030001469857\",  \"ipt_patn_disediag_type_code\": \"\",  \"disediag_type\": \"\",  \"maindiag_flag\": \"0\",  \"diag_code\": \"E87.201\",  \"diag_name\": \"代谢性酸中毒\",  \"inhosp_diag_code\": \"\",  \"inhosp_diag_name\": \"\",  \"adm_dise_cond_name\": \"\",  \"adm_dise_cond_code\": \"\",  \"adm_cond\": \"\",  \"adm_cond_code\": \"\",  \"high_diag_evid\": \"\",  \"bkup_deg\": \"\",  \"bkup_deg_code\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\",  \"fixmedins_code\": \"H51010501809\"},{  \"palg_no\": \"ZY00030001469857\",  \"ipt_patn_disediag_type_code\": \"\",  \"disediag_type\": \"\",  \"maindiag_flag\": \"0\",  \"diag_code\": \"E87.800x011\",  \"diag_name\": \"电解质紊乱\",  \"inhosp_diag_code\": \"\",  \"inhosp_diag_name\": \"\",  \"adm_dise_cond_name\": \"\",  \"adm_dise_cond_code\": \"\",  \"adm_cond\": \"\",  \"adm_cond_code\": \"\",  \"high_diag_evid\": \"\",  \"bkup_deg\": \"\",  \"bkup_deg_code\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\",  \"fixmedins_code\": \"H51010501809\"}  ],  \"oprninfo\": [{  \"oprn_oprt_date\": \"2022-05-02\",  \"oprn_oprt_name\": \"气管内插管\",  \"oprn_oprt_code\": \"96.0400\",  \"oprn_oprt_sn\": \"\",  \"oprn_lv_code\": \"\",  \"oprn_lv_name\": \"\",  \"oper_name\": \"杨陈\",  \"asit1_name\": \"\",  \"asit2_name\": \"\",  \"sinc_heal_lv\": \"\",  \"sinc_heal_lv_code\": \"\",  \"anst_mtd_name\": \"\",  \"anst_mtd_code\": \"\",  \"anst_dr_name\": \"\",  \"oprn_oper_part\": \"\",  \"oprn_oper_part_code\": \"\",  \"oprn_con_time\": \"\",  \"anst_lv_name\": \"\",  \"anst_lv_code\": \"\",  \"oprn_patn_type\": \"\",  \"oprn_patn_type_code\": \"\",  \"main_oprn_flag\": \"\",  \"anst_asa_lv_code\": \"\",  \"anst_asa_lv_name\": \"\",  \"anst_medn_code\": \"\",  \"anst_medn_name\": \"\",  \"anst_medn_dos\": \"\",  \"unt\": \"\",  \"anst_begntime\": \"2022-05-02 00:00:00\",  \"anst_endtime\": \"2022-05-02 00:00:00\",  \"anst_copn_code\": \"\",  \"anst_copn_name\": \"\",  \"anst_copn_dscr\": \"\",  \"pacu_begntime\": \"\",  \"pacu_endtime\": \"\",  \"canc_oprn_flag\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\"},{  \"oprn_oprt_date\": \"2022-05-02\",  \"oprn_oprt_name\": \"呼吸机治疗[小于96小时]\",  \"oprn_oprt_code\": \"96.7101\",  \"oprn_oprt_sn\": \"\",  \"oprn_lv_code\": \"\",  \"oprn_lv_name\": \"\",  \"oper_name\": \"杨陈\",  \"asit1_name\": \"\",  \"asit2_name\": \"\",  \"sinc_heal_lv\": \"\",  \"sinc_heal_lv_code\": \"\",  \"anst_mtd_name\": \"\",  \"anst_mtd_code\": \"\",  \"anst_dr_name\": \"\",  \"oprn_oper_part\": \"\",  \"oprn_oper_part_code\": \"\",  \"oprn_con_time\": \"\",  \"anst_lv_name\": \"\",  \"anst_lv_code\": \"\",  \"oprn_patn_type\": \"\",  \"oprn_patn_type_code\": \"\",  \"main_oprn_flag\": \"\",  \"anst_asa_lv_code\": \"\",  \"anst_asa_lv_name\": \"\",  \"anst_medn_code\": \"\",  \"anst_medn_name\": \"\",  \"anst_medn_dos\": \"\",  \"unt\": \"\",  \"anst_begntime\": \"2022-05-02 00:00:00\",  \"anst_endtime\": \"2022-05-02 00:00:00\",  \"anst_copn_code\": \"\",  \"anst_copn_name\": \"\",  \"anst_copn_dscr\": \"\",  \"pacu_begntime\": \"\",  \"pacu_endtime\": \"\",  \"canc_oprn_flag\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\"},{  \"oprn_oprt_date\": \"2022-05-02\",  \"oprn_oprt_name\": \"颈内静脉穿刺中心静脉置管术\",  \"oprn_oprt_code\": \"38.9302\",  \"oprn_oprt_sn\": \"\",  \"oprn_lv_code\": \"\",  \"oprn_lv_name\": \"\",  \"oper_name\": \"杨陈\",  \"asit1_name\": \"\",  \"asit2_name\": \"\",  \"sinc_heal_lv\": \"\",  \"sinc_heal_lv_code\": \"\",  \"anst_mtd_name\": \"\",  \"anst_mtd_code\": \"\",  \"anst_dr_name\": \"\",  \"oprn_oper_part\": \"\",  \"oprn_oper_part_code\": \"\",  \"oprn_con_time\": \"\",  \"anst_lv_name\": \"\",  \"anst_lv_code\": \"\",  \"oprn_patn_type\": \"\",  \"oprn_patn_type_code\": \"\",  \"main_oprn_flag\": \"\",  \"anst_asa_lv_code\": \"\",  \"anst_asa_lv_name\": \"\",  \"anst_medn_code\": \"\",  \"anst_medn_name\": \"\",  \"anst_medn_dos\": \"\",  \"unt\": \"\",  \"anst_begntime\": \"2022-05-02 00:00:00\",  \"anst_endtime\": \"2022-05-02 00:00:00\",  \"anst_copn_code\": \"\",  \"anst_copn_name\": \"\",  \"anst_copn_dscr\": \"\",  \"pacu_begntime\": \"\",  \"pacu_endtime\": \"\",  \"canc_oprn_flag\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\"},{  \"oprn_oprt_date\": \"2022-05-02\",  \"oprn_oprt_name\": \"全身动脉压监测\",  \"oprn_oprt_code\": \"89.6100\",  \"oprn_oprt_sn\": \"\",  \"oprn_lv_code\": \"\",  \"oprn_lv_name\": \"\",  \"oper_name\": \"杨陈\",  \"asit1_name\": \"\",  \"asit2_name\": \"\",  \"sinc_heal_lv\": \"\",  \"sinc_heal_lv_code\": \"\",  \"anst_mtd_name\": \"\",  \"anst_mtd_code\": \"\",  \"anst_dr_name\": \"\",  \"oprn_oper_part\": \"\",  \"oprn_oper_part_code\": \"\",  \"oprn_con_time\": \"\",  \"anst_lv_name\": \"\",  \"anst_lv_code\": \"\",  \"oprn_patn_type\": \"\",  \"oprn_patn_type_code\": \"\",  \"main_oprn_flag\": \"\",  \"anst_asa_lv_code\": \"\",  \"anst_asa_lv_name\": \"\",  \"anst_medn_code\": \"\",  \"anst_medn_name\": \"\",  \"anst_medn_dos\": \"\",  \"unt\": \"\",  \"anst_begntime\": \"2022-05-02 00:00:00\",  \"anst_endtime\": \"2022-05-02 00:00:00\",  \"anst_copn_code\": \"\",  \"anst_copn_name\": \"\",  \"anst_copn_dscr\": \"\",  \"pacu_begntime\": \"\",  \"pacu_endtime\": \"\",  \"canc_oprn_flag\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\"},{  \"oprn_oprt_date\": \"2022-05-02\",  \"oprn_oprt_name\": \"中心静脉压监测\",  \"oprn_oprt_code\": \"89.6200\",  \"oprn_oprt_sn\": \"\",  \"oprn_lv_code\": \"\",  \"oprn_lv_name\": \"\",  \"oper_name\": \"杨陈\",  \"asit1_name\": \"\",  \"asit2_name\": \"\",  \"sinc_heal_lv\": \"\",  \"sinc_heal_lv_code\": \"\",  \"anst_mtd_name\": \"\",  \"anst_mtd_code\": \"\",  \"anst_dr_name\": \"\",  \"oprn_oper_part\": \"\",  \"oprn_oper_part_code\": \"\",  \"oprn_con_time\": \"\",  \"anst_lv_name\": \"\",  \"anst_lv_code\": \"\",  \"oprn_patn_type\": \"\",  \"oprn_patn_type_code\": \"\",  \"main_oprn_flag\": \"\",  \"anst_asa_lv_code\": \"\",  \"anst_asa_lv_name\": \"\",  \"anst_medn_code\": \"\",  \"anst_medn_name\": \"\",  \"anst_medn_dos\": \"\",  \"unt\": \"\",  \"anst_begntime\": \"2022-05-02 00:00:00\",  \"anst_endtime\": \"2022-05-02 00:00:00\",  \"anst_copn_code\": \"\",  \"anst_copn_name\": \"\",  \"anst_copn_dscr\": \"\",  \"pacu_begntime\": \"\",  \"pacu_endtime\": \"\",  \"canc_oprn_flag\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\"},{  \"oprn_oprt_date\": \"2022-05-03\",  \"oprn_oprt_name\": \"心肺复苏\",  \"oprn_oprt_code\": \"99.6000\",  \"oprn_oprt_sn\": \"\",  \"oprn_lv_code\": \"\",  \"oprn_lv_name\": \"\",  \"oper_name\": \"刘明宗\",  \"asit1_name\": \"\",  \"asit2_name\": \"\",  \"sinc_heal_lv\": \"\",  \"sinc_heal_lv_code\": \"\",  \"anst_mtd_name\": \"\",  \"anst_mtd_code\": \"\",  \"anst_dr_name\": \"\",  \"oprn_oper_part\": \"\",  \"oprn_oper_part_code\": \"\",  \"oprn_con_time\": \"\",  \"anst_lv_name\": \"\",  \"anst_lv_code\": \"\",  \"oprn_patn_type\": \"\",  \"oprn_patn_type_code\": \"\",  \"main_oprn_flag\": \"\",  \"anst_asa_lv_code\": \"\",  \"anst_asa_lv_name\": \"\",  \"anst_medn_code\": \"\",  \"anst_medn_name\": \"\",  \"anst_medn_dos\": \"\",  \"unt\": \"\",  \"anst_begntime\": \"2022-05-03 00:00:00\",  \"anst_endtime\": \"2022-05-03 00:00:00\",  \"anst_copn_code\": \"\",  \"anst_copn_name\": \"\",  \"anst_copn_dscr\": \"\",  \"pacu_begntime\": \"\",  \"pacu_endtime\": \"\",  \"canc_oprn_flag\": \"\",  \"vali_flag\": \"1\",  \"ipt_medcas_hmpg_sn\": \"ZY00030001469857\",  \"mdtrt_sn\": \"H51010501809ZY00030001469857\"}  ],  \"icuinfo\": []}}";
        System.out.println(intput);

      String abc =  YinHaiUtil.Api(intput,1);
        System.out.println(abc);


    }

}
