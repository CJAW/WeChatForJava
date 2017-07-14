package com.wechat.getpicture;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.wechat.createTwoCode.CreateTwoCode;
import com.wechat.https.HttpsConUtil;
import com.wechat.parseJsonAndCreateJson.ParseJsonBean;
import com.wechat.urlChangeUTF8.UrlChangeUTF8;

/**
 * 通过ticket和url换取二维码的图片
 * @author user
 *
 */
public class GetPicture {

	public static String getPicture(String savePath){
		
		//解析json
		Gson gson = new Gson();
		ParseJsonBean parseJsonBean = gson.fromJson(CreateTwoCode.createCode(),ParseJsonBean.class);
		
		//获取ticket,将ticket进行转码，变成utf-8的编码
		String ticket = UrlChangeUTF8.changeEconding(parseJsonBean.getTicket(),"UTF-8");
	
		
		//将图片写入指定的文件路径
		//创建路径
		String Path = savePath+11+".jpg";
		HttpsURLConnection httpsURLConnection =null;
		try {
			URL Url = new URL("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticket);
			httpsURLConnection = (HttpsURLConnection) Url.openConnection();
			httpsURLConnection.setRequestMethod("GET");
			//文件的拷贝
		    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
			OutputStream outputStream = new FileOutputStream(new File(Path));
			//设置缓冲
			byte[] by = new byte[8096];
			int size =0;
			//读取
			while((size = bufferedInputStream.read())!=-1){
				
				outputStream.write(by, 0, size);
                outputStream.flush();				
			}
			
		
			outputStream.close();
			bufferedInputStream.close();
			httpsURLConnection.disconnect();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//返回路径
		return Path;
	}
	
	public static void main(String[] args){
		
		getPicture("/Users/user/Desktop/PHP/");
	}
	
}
