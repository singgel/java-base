/*
 * @Author: 阿拉斯加大闸蟹 hekuangsheng@163.com
 * @Date: 2023-02-03 03:04:20
 * @LastEditors: 阿拉斯加大闸蟹 hekuangsheng@163.com
 * @LastEditTime: 2023-02-03 03:07:18
 * @FilePath: /java-base/java-network/cidr.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Cidr {
	
	public static void main(String[] args) {
		System.err.println(subnetDivide("117.72.16.0/23",10));
	}
	
	/***
	 * 判断一个数是否是2的次幂
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwo(int n) {
        String str = Integer.toBinaryString(n);
        if(n < 1) {
			return false;
		} else if(str.lastIndexOf("1") == 0) {
			return true;
		} else {
			return false;
		}
  }
	
	
//	public static String toBinary(String str){ //把字符串转成字符数组 
//		char[] strChar=str.toCharArray(); 
//		String result=""; 
//		for(int i=0;i<strChar.length;i++){ 
//			//toBinaryString(int i)返回变量的二进制表示的字符串 
//			//toHexString(int i) 八进制 
//			//toOctalString(int i) 十六进制 
//			result +=Integer.toBinaryString(strChar[i])+ " ";
//		} 
//		return result; 
//	}
	/***
	 * 大于等于2的次幂的最小值
	 * @param v 任意数
	 * @return
	 */
	public static int roundup_power_of_2(int v)
	{
		v--;
		v |= v >> 1;
		v |= v >> 2;
		v |= v >> 4;
		v |= v >> 8;
		v |= v >> 16;
		v++;
		return v;
	}
	
	/***
	 * 2的次幂
	 * @param n 次幂
	 * @return
	 */
	private static int calculate2Num(int n) {
        if (n == 0) {
			return 1;
		}
        return 2 * calculate2Num(n - 1);
    }
	/***
	 * 具体划分步骤
	 * @return
	 */
	public static List<String> divideByPow(String ips,int pow){
//		Map<String,String> map=new HashMap<>();
		List<String> ipList = new ArrayList<String>();
		try {
			if(ips ==null || "".equals(ips.trim()) || "null".equals(ips.trim())){
				return ipList;
			}
			ips = ips.trim();
			if(ips.indexOf("/")>0) {
				String temp[] = ips.split("/");
				if(temp.length == 2 && isIP(temp[0])){
					String ip=temp[0];
					String subnet=temp[1];
					String ipBitStr = makeBinaryString( getIpFromString(ip).intValue());
					int leg = ipBitStr.length();
					int bitNum  = Integer.parseInt(subnet);
					String str0 = "00000000000000000000000000000000";
					String str1 = "11111111111111111111111111111111";
					if(bitNum <= 32){
						String startIPBit = ipBitStr.substring(0, leg-(32-bitNum))+str0.substring(0, 32-bitNum);
						String endIPBit   = ipBitStr.substring(0, leg-(32-bitNum))+str1.substring(0, 32-bitNum);
						Long  startIPLong = getIpFromString(getIpStringFrom10bit(startIPBit));
						Long  endIPLong   =  getIpFromString(getIpStringFrom10bit(endIPBit));
						Integer midNum=Integer.valueOf(1+str0.substring(0, 32-(bitNum+pow)), 2);
						int subnetT=bitNum+pow;
						for (int i = 0; i < calculate2Num(pow); i++) {
//							map.put(getIpFromLong(startIPLong)+"/"+subnetT,getIpFromLong(startIPLong)+"/"+subnetT);
							ipList.add(getIpFromLong(startIPLong)+"/"+subnetT);
							startIPLong+=midNum;
						}
					}
					
//					System.err.println(ipList+"--------------");
				}
			}
			return ipList;
		} catch (Exception e) {
			return ipList;
		}
	}
	/***
	 * 小于等于2的次幂的最大值
	 * @param subNum 划分数目
	 * @return pow 2的几次幂
	 */
	public static int judge(int subNum) {
		int pow=0;
		if(isPowerOfTwo(subNum)) {//是否是2的次幂
			pow=(int) (Math.log(subNum)/Math.log(2));//2的几次幂
		}else {
			pow=roundup_power_of_2(subNum)/2;//小于等于2的次幂的最大值
			pow=(int) (Math.log(pow)/Math.log(2));
		}
		return pow;
	}
	
	
	/***
	 * 子网划分
	 * @param ips 网段192.168.0.0/22
	 * @param subNum 子网划分数量
	 * @return
	 */
	public static List<String> subnetDivide(String ips,int subNum) {
		List<String> ipList = new ArrayList<String>();
		if(subNum>1){
			int pow =judge(subNum);
			int difference=subNum-calculate2Num(pow);
			ipList =divideByPow(ips,pow);//第一次划分
			if(difference!=0) {
				while (difference>0) {
					if(difference==1) {
						difference--;
						ipList.addAll(divideByPow(ipList.get(0),1));
						ipList.remove(ipList.get(0));
					}else {
						pow =judge(difference);
						difference=difference-calculate2Num(pow);
						for (int i = 0; i < calculate2Num(pow); i++) {
							ipList.addAll(divideByPow(ipList.get(0),pow));
							ipList.remove(ipList.get(0));
						}
						
					}
				}
			}
		}else {
			ipList.add(ips);
		}
		return ipList;
	}
	
	/** 
     * 把long类型的Ip转为一般Ip类型：xx.xx.xx.xx 
     * 
     * @param ip 
     * @return 
     */  
    public static String getIpFromLong(Long ip)  
    {  
        String s1 = String.valueOf((ip & 4278190080L) / 16777216L);  
        String s2 = String.valueOf((ip & 16711680L) / 65536L);  
        String s3 = String.valueOf((ip & 65280L) / 256L);  
        String s4 = String.valueOf(ip & 255L);  
        return s1 + "." + s2 + "." + s3 + "." + s4;  
    }  
    /** 
     * 把xx.xx.xx.xx类型的转为long类型的 
     * 
     * @param ip 
     * @return 
     */  
    public static Long getIpFromString(String ip)  
    {  
        Long ipLong = 0L;  
        String ipTemp = ip;  
        ipLong = ipLong * 256  
                + Long.parseLong(ipTemp.substring(0, ipTemp.indexOf('.')));  
        ipTemp = ipTemp.substring(ipTemp.indexOf('.') + 1, ipTemp.length());  
        ipLong = ipLong * 256  
                + Long.parseLong(ipTemp.substring(0, ipTemp.indexOf('.')));  
        ipTemp = ipTemp.substring(ipTemp.indexOf(".") + 1, ipTemp.length());  
        ipLong = ipLong * 256  
                + Long.parseLong(ipTemp.substring(0, ipTemp.indexOf('.')));  
        ipTemp = ipTemp.substring(ipTemp.indexOf('.') + 1, ipTemp.length());  
        ipLong = ipLong * 256 + Long.parseLong(ipTemp);  
        return ipLong;  
    }  
    /** 
     * 根据掩码位获取掩码 
     * 
     * @param maskBit 
     *            掩码位数，如"28"、"30" 
     * @return 
     */  
    public static String getMaskByMaskBit(String maskBit)  
    {  
        return "".equals(maskBit) ? "error, maskBit is null !" : getMaskMap(maskBit);  
    }  
      
    /** 
     * 根据 ip/掩码位 计算IP段的起始IP 如 IP串 218.240.38.69/30 
     * 
     * @param ip 
     *            给定的IP，如218.240.38.69 
     * @param maskBit 
     *            给定的掩码位，如30 
     * @return 起始IP的字符串表示 
     */  
    public static String getBeginIpStr(String ip, String maskBit)  
    {  
        return getIpFromLong(getBeginIpLong(ip, maskBit));  
    }  
    /** 
     * 根据 ip/掩码位 计算IP段的起始IP 如 IP串 218.240.38.69/30 
     * 
     * @param ip 
     *            给定的IP，如218.240.38.69 
     * @param maskBit 
     *            给定的掩码位，如30 
     * @return 起始IP的长整型表示 
     */  
    public static Long getBeginIpLong(String ip, String maskBit)  
    {  
        return getIpFromString(ip) & getIpFromString(getMaskByMaskBit(maskBit));  
    }  
    /** 
     * 根据 ip/掩码位 计算IP段的终止IP 如 IP串 218.240.38.69/30 
     * 
     * @param ip 
     *            给定的IP，如218.240.38.69 
     * @param maskBit 
     *            给定的掩码位，如30 
     * @return 终止IP的字符串表示 
     */  
    public static String getEndIpStr(String ip, String maskBit)  
    {  
        return getIpFromLong(getEndIpLong(ip, maskBit));  
    }  
      
     /** 
     * 根据 ip/掩码位 计算IP段的终止IP 如 IP串 218.240.38.69/30 
     * 
     * @param ip 
     *            给定的IP，如218.240.38.69 
     * @param maskBit 
     *            给定的掩码位，如30 
     * @return 终止IP的长整型表示 
     */  
    public static Long getEndIpLong(String ip, String maskBit)  
    {  
        return getBeginIpLong(ip, maskBit)  
                + ~getIpFromString(getMaskByMaskBit(maskBit));  
    }  
    
    public static String getMaskMap(String maskBit) {
    	switch (maskBit){
			case "1" : return "128.0.0.0";
			case "2" : return "192.0.0.0";
			case "3" : return "224.0.0.0";
			case "4" : return "240.0.0.0";
			case "5" : return "248.0.0.0";
			case "6" : return "252.0.0.0";
			case "7" : return "254.0.0.0";
			case "8" : return "255.0.0.0";
			case "9" : return "255.128.0.0";
			case "10" : return "255.192.0.0";
			case "11" : return "255.224.0.0";
			case "12" : return "255.240.0.0";
			case "13" : return "255.248.0.0";
			case "14" : return "255.252.0.0";
			case "15" : return "255.254.0.0";
			case "16" : return "255.255.0.0";
			case "17" : return "255.255.128.0";
			case "18" : return "255.255.192.0";
			case "19" : return "255.255.224.0";
			case "20" : return "255.255.240.0";
			case "21" : return "255.255.248.0";
			case "22" : return "255.255.252.0";
			case "23" : return "255.255.254.0";
			case "24" : return "255.255.255.0";
			case "25" : return "255.255.255.128";
			case "26" : return "255.255.255.192";
			case "27" : return "255.255.255.224";
			case "28" : return "255.255.255.240";
			case "29" : return "255.255.255.248";
			case "30" : return "255.255.255.252";
			case "31" : return "255.255.255.254";
			case "32" : return "255.255.255.255";
			default: return "-1";
		}
    }
    
    
    /**
	 * 十进制转换成二进制
	 */
	public static String makeBinaryString(int i){
		String binary = "";  
		do{  
			int Bit = (i & 1);  
			String newDigit = ((Bit == 0) ? "0" : "1");  
			binary = newDigit + binary;  
			i >>>= 1;  
		}while (i != 0);  
		return binary; 
	}
    
	/**
	 * 
	 *  输入从10进制转换过来的2进制，再转换成ip地址
	 * @return
	 */
	public static  String getIpStringFrom10bit(String ss)
	{
		while(ss.length() <32 ){
			ss = "0"+ss ;
		}

		String[] ssArray =new String [8];

		ssArray[0]=ss.substring(0, 8);
		ssArray[1]=ss.substring(8, 16);
		ssArray[2]=ss.substring(16, 24);
		ssArray[3]=ss.substring(24, 32);

		String sttttt=
				Integer.valueOf(ssArray[0],2).toString()
				+'.'+Integer.valueOf(ssArray[1],2).toString()
				+'.'+Integer.valueOf(ssArray[2],2).toString()
				+'.'+Integer.valueOf(ssArray[3],2).toString();		 

		return sttttt;
	}
	
	/** 
     * 功能：根据位数返回IP总数 
     * 格式：isIP("192.192.192.1") 
     */  
    public static boolean isIP(String str) {    
        String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";    
        Pattern pattern = Pattern.compile(regex);    
        return pattern.matcher(str).matches();    
    } 
}
