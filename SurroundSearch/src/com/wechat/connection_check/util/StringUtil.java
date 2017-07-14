package com.wechat.connection_check.util;

/**
 *  配置微信的参数，及效验。
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class StringUtil {

	//与开发模式接口配置信息的token一致
	private static String token = "1234567";
	
	//signature 微信签名
	//timestamp 时间戳
	//nonce 随机数
	public static boolean checkSignature(String signature, String timestamp,String nonce){
		
		//排序
		String[] parmaArr = new String[]{token,timestamp,nonce};
		Arrays.sort(parmaArr);
		//拼接
		String connect = parmaArr[0].concat(parmaArr[1]).concat(parmaArr[2]);
		
		String ciphertext = null;
		
		try {
			//对信息进行加密
			MessageDigest  md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(connect.toString().getBytes());
			//将字节转化为字符
			ciphertext = byteToStr(digest);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ciphertext !=null ? ciphertext.equals(signature.toUpperCase()) :false;
	}
	
	
	/**
	 * 将字节数组转化为十六进制的字符串
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray){
		
		String strDigets ="";
		
		for(int i=0;i<byteArray.length;i++){
			strDigets +=byteToHexStr(byteArray[i]);
			
		}
		
		return strDigets;
		
	}
	
	
	/**
	 * 将字节转换位十六进制的字符串
	 */
   private static String byteToHexStr(byte mByte){
	   char[]  Digit = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	   char[] tempArr =  new char[2];
	   tempArr[0] = Digit[(mByte>>>4) & 0x0F];
	   tempArr[1] = Digit[mByte & 0x0F];
	   
	   String s = new String (tempArr);
	   return s;
	   
   }
	
	
	
	
}
