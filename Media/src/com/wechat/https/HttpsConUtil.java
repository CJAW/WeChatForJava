package com.wechat.https;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import com.google.gson.Gson;
import com.wechat.myX509TureManager.MyX509TureManager;

/**
 * 对URL的请求进行封装
 */


public class HttpsConUtil {

	public static String request(String JsonMessage, String Url, String Method, String econding) {

		
		HttpsURLConnection httpsURLConnection = null;
		StringBuilder stringBuilder = null;
		// 设置流,读取返回信息
		BufferedReader bufferedReader;
		try {	
			URL url = new URL(Url);
			// 请求
			httpsURLConnection = (HttpsURLConnection) url.openConnection();
			// 自定义的信任管理器
			TrustManager[] trustManager = { new MyX509TureManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, trustManager, new java.security.SecureRandom());
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			httpsURLConnection.setSSLSocketFactory(ssf);
			// 开启读取流
			httpsURLConnection.setDoInput(true);
			httpsURLConnection.setDoOutput(true);
			// 设置请求方式
			httpsURLConnection.setRequestMethod(Method);

			// 写入流，字节流，将json格式的菜单写入微信服务器
			OutputStream outputStream = httpsURLConnection.getOutputStream();
			outputStream.write(JsonMessage.getBytes(econding));
		
			outputStream.close();

			bufferedReader = new BufferedReader(
					new InputStreamReader(httpsURLConnection.getInputStream(), econding));
			
			// 读取
			stringBuilder = new StringBuilder(); // 缓冲
			String message = null;

			while ((message = bufferedReader.readLine()) != null) {
				stringBuilder.append(message);
			}
			bufferedReader.close();
			httpsURLConnection.disconnect();
			

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (NoSuchProviderException e) {

			e.printStackTrace();
		} catch (KeyManagementException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// 返回结果json的数据
		return stringBuilder.toString();
	}
	
	
	
	
	public static String httpConUtil(String Url,String Method,String econding){
		
		/**
		 * 网页读取
		 */
		HttpsURLConnection httpsURLConnection = null;

		StringBuilder stringBuilder = null;
		URL url = null;
		// 设置流,读取返回信息
		BufferedReader bufferedReader;
		try {
			
			url = new URL(Url);
			httpsURLConnection = (HttpsURLConnection) url.openConnection();
			
			// 开启读取流
						httpsURLConnection.setDoInput(true);
						httpsURLConnection.setDoOutput(true);
						// 设置请求方式
						httpsURLConnection.setRequestMethod(Method);
			
			bufferedReader = new BufferedReader(
					new InputStreamReader(httpsURLConnection.getInputStream(), econding));
			
			// 读取
			stringBuilder = new StringBuilder(); // 缓冲
			String message = null;

			while ((message = bufferedReader.readLine()) != null) {
				stringBuilder.append(message);
			}
			bufferedReader.close();
			httpsURLConnection.disconnect();
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stringBuilder.toString();
	}
	
	/**
	 * 上传多媒体文件，构造请求的form表单
	 * @param Url
	 * @param Method
	 * @param econding
	 * @return
	 */
	public static String upLoadMedia(String Url,String mediaFileUrl, String Method, String econding){
		
		String boundary = "------------------7da2e536604c8";
		StringBuilder stringBuilder = null;
		try {
			
			//请求地址
			URL url = new URL(Url);
			HttpsURLConnection httpsURLConnection =  (HttpsURLConnection) url.openConnection();

			// 自定义的信任管理器
			TrustManager[] trustManager = { new MyX509TureManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, trustManager, new java.security.SecureRandom());
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			httpsURLConnection.setSSLSocketFactory(ssf);
			
			httpsURLConnection.setDoOutput(true);
			httpsURLConnection.setDoInput(true);
			httpsURLConnection.setRequestMethod(Method);
			httpsURLConnection.setRequestProperty("Content-Type","multipart/form-data;boundary="+boundary);
			//写入微信服务器
			OutputStream outputStream = httpsURLConnection.getOutputStream();
			
			
			
			//获取图片的位置
			URL mfl = new URL(mediaFileUrl); 
			HttpURLConnection mediaUrl = (HttpURLConnection) mfl.openConnection();
			mediaUrl.setDoInput(true);
			mediaUrl.setDoOutput(true);
			mediaUrl.setRequestMethod("GET");
			
			//获取请求的数据类型
			String contentType = mediaUrl.getHeaderField("Content-Type");
			//根据文件类型判断文件扩展名
			String fileExt =GetFileExt.getFileExt(contentType);
					
			// 构建请求体
			outputStream.write(("--" + boundary + "\r\n").getBytes());
			outputStream.write(
					String.format("Content-Disposition:form-data;name=\"media\";filename=\"file%s\"\r\n", fileExt).getBytes());

			outputStream.write(String.format("Content-Type:%s\r\n\r\n", contentType).getBytes());
			//根据路径读取读取多媒体文件
			BufferedInputStream bufferedInputStream = new BufferedInputStream(mediaUrl.getInputStream());
			//定义缓冲
			byte[] b = new byte[8096];
			//接受的容器
			int size = 0;
			while((size=bufferedInputStream.read(b))!=-1){
				
				outputStream.write(b, 0,size );
			}
			outputStream.write(("\r\n--" + boundary +"--\r\n\r\n" ).getBytes());
			
			outputStream.close();
		
			bufferedInputStream.close();
			
			
			//读取微信服务器返回的数据
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream(), econding));
			//接收容器
			 stringBuilder = new StringBuilder();
			//缓冲
			String message =null;
			while((message = bufferedReader.readLine())!=null){
				stringBuilder.append(message);
				
			}
			bufferedReader.close();
			mediaUrl.disconnect();
			httpsURLConnection.disconnect();
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stringBuilder.toString();
	}
	
	
public static String httpsDownLoadMedia(String savePath,String url,String Metho){
		
		// 将图片写入指定的文件路径
		// 创建路径
		String Path = null;
		HttpsURLConnection httpsURLConnection = null;
		HttpURLConnection httpURLConnection = null;
		BufferedInputStream bufferedInputStream = null;
		OutputStream outputStream = null;

		try {
			URL Url = new URL(url);

			httpsURLConnection = (HttpsURLConnection) Url.openConnection();
			httpsURLConnection.setRequestMethod(Metho);
			String Type = GetFileExt.getFileExt(httpsURLConnection.getHeaderField("Content-Type"));
			Path = savePath + System.currentTimeMillis() + Type;

			if (Type.equals(".mp4")) {

				httpURLConnection = (HttpURLConnection) Url.openConnection();
				httpURLConnection.setRequestMethod(Metho);
				// 文件的拷贝
				bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
				outputStream = new FileOutputStream(new File(Path));
				// 设置缓冲
				byte[] by = new byte[1024];
				int size = 0;
				// 读取
				while ((size = bufferedInputStream.read()) !=-1) {

					outputStream.write(by, 0, size);
					outputStream.flush();
				}
				

			} else {

				// 文件的拷贝
				bufferedInputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
				outputStream = new FileOutputStream(new File(Path));
				// 设置缓冲
				byte[] by = new byte[1024];
				int size = 0;
				// 读取
				while ((size = bufferedInputStream.read()) !=-1) {

					outputStream.write(by, 0, size);
					outputStream.flush();
				}
				
			}

			outputStream.close();
			bufferedInputStream.close();
			httpsURLConnection.disconnect();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 返回路径
		return Path;
	}
	
}

