package com.wechat.emoji;

/**
 * 
 * @author user
 *将表情符号进行转码
 */

public class CharEmjio {

	public static String charEmjio(int codePoint){
		
		return String.valueOf(Character.toChars(codePoint));
		
	}
}
