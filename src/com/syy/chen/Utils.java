package com.syy.chen;

import java.io.Reader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.sql.Clob;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    public static String SqlTimeToTime(Object time)  {
        if (time==null || time.equals("")){
            return null;
        }else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = simpleDateFormat.parse(time.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return simpleDateFormat.format(date);
        }
    }
    public static String SqlTimeToDate(Object time) throws ParseException {
        if (time==null || time.equals("")){
            return null;
        }else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(time.toString());
            return simpleDateFormat.format(date);
        }
    }

    /**
     * 医保分类处理
     * @param yb
     * @return
     */
    public static String YbFenLei (String yb) {
        String re ;
        if (yb.startsWith("51")){
            if (yb.startsWith("5101")){
                re ="1";
            }else if (yb.startsWith("5199")){
                re ="2";
            }else {
                re="3";
            }
        }else {
            re ="4";
        }
        return re;
    }

    /**
     * 获取党建时间
     * @return
     */
    public static String GetNowTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(System.currentTimeMillis());
    }

    public static synchronized void SqlStringAppend(StringBuffer str, int num, String s) {
        if (s==null){
            if (num==0){
                str.append("null)");
            }else {
                str.append("null,");
            }
        }else {
            String s1 ="'"+Utils.replaceUtil(s)+"'";
            if (num==0){
                str.append(s1);
                str.append(")");
            }else {
                str.append(s1);
                str.append(",");
            }

        }
    }
    public static synchronized void SqlIntAppend(StringBuffer str, int num, String s) {
        if (s==null){
            if (num==0){
                str.append("null)");
            }else {
                str.append("null,");
            }
        }else {
            if (num==0){
                str.append(s);
                str.append(")");
            }else {
                str.append(s);
                str.append(",");
            }

        }
    }
    public static synchronized void SqlDateAppend(StringBuffer str, int num, Object s) {
        if (s==null){
            if (num==0){
                str.append("null)");
            }else {
                str.append("null,");
            }
        }else {
            String s1 ="to_date('"+s+"','yyyy-mm-dd')";
            if (num==0){
                str.append(s1);
                str.append(")");
            }else {
                str.append(s1);
                str.append(",");
            }

        }
    }

    /**
     *
     * @param str
     * @param num
     * @param s
     */
    public static synchronized void SqlTimeAppend(StringBuffer str, int num, Object s) {
        if (s==null||s.equals("")){
            if (num==0){
                str.append("null)");
            }else {
                str.append("null,");
            }
        }else {
            String s1 ="to_date('"+s+"','yyyy-mm-dd HH24:mi:ss')";
            if (num==0){
                str.append(s1);
                str.append(")");
            }else {
                str.append(s1);
                str.append(",");
            }
        }
    }
    /**
     * 时间转换成时间戳
     * @param  s
     * @return res
     * @throws ParseException
     */
    public static long dateToStamp(String s) throws ParseException {
        //String res;
        //设置时间模版
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
       // res = String.valueOf(ts);
        return ts/1000;
    }

    /**
     *  计算银海时间长度
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @return 返回时间长都
     * @throws ParseException
     */
    public static String timeToYb(String beginTime,String endTime) throws ParseException {
        long begin =dateToStamp(beginTime);
        long end =dateToStamp(endTime);
        long num = end-begin;
        return SjZhuanFan(num/60);
    }

    /**
     * 时间转换成银海要求的格式  0/0/0
     * @param num
     * @return
     */
    public static String SjZhuanFan(long num) {
        String rs ;
        if (num < 60) {
            rs = "0/0/" + num;
        } else {
            if (num < 1440) {
                rs = "0/" + num/60 + "/" + num%60;
            } else {
               long a = num % 1440;
                if (a < 60) {
                    rs = num/1440 + "/0/" +a;
                } else {
                    long b = a/60;
                    long c1 = a % 60;
                    rs = num/1440 + "/" + b + "/" +c1;
                }
            }
        }
        return rs;
    }

    /**
     *数据库clob转String
     * @param c
     * @return
     */
    public static String clobToString(Clob c) {
        StringBuffer sb = new StringBuffer(1024);
        Reader instream = null;
        try {
            instream = c.getCharacterStream();
            char[] buffer = new char[(int) c.length()];
            int length = 0;
            while ((length = instream.read(buffer)) != -1) {
                sb.append(buffer, 0, length);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                if (instream != null)
                    instream.close();
            } catch (Exception dx) {
                instream = null;
            }
        }
        return sb.toString();
    }

    /**
     * 获取几天前时间
     * @param day
     * @return
     */
    public static String getDateBefore(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -day); //得到前一天
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    /**
     * null 转成“”
     * @param ob 数据库查记过
     * @return
     */
    public static String sqlNullToString(Object ob){
        if (ob==null || ob.equals("")){
            return "";
        }else {
            return ob.toString();
        }
    }


    /**
     * 将字符串包含的'转传承‘’
     * @param string 要转换的字符
     * @return 返回转换后的字符
     */
    public static String replaceUtil(String string){
       return string.replace( "'", "''");
    }

    /**
     * 获取IP地址
     */
    public static String getIpAddressInWindows() {
        String ip = null;
        try {
            InetAddress address = InetAddress.getLocalHost();
           // System.out.println("Host Name: " + address.getHostName());
           // System.out.println("Host Address: " + address.getHostAddress());
            ip = address.getHostAddress();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }
    /**
     * 获取本地mac地址
     * 注意：物理地址是48位，别和ipv6搞错了
     * @return 本地mac地址
     */
    public static String getLocalMac() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            //获取网卡，获取地址
            byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    sb.append("-");
                }
                //字节转换为整数
                int temp = mac[i] & 0xff;
                String str = Integer.toHexString(temp);
                if (str.length() == 1) {
                    sb.append("0" + str);
                } else {
                    sb.append(str);
                }
            }
            return sb.toString();
        } catch (Exception ignored) {
        }
        return null;
    }
    public static  String stringNullToNotNull(String s){
        if (s==null){
            return "-";
        }else {
            if (s.equals("")){
                return "-";
            }else {
                return s;
            }
        }
    }
    public static String telYc(String tel){
        if (tel.length()>20){
            return tel.substring(0,11);
        }
        return tel;
    }

}
