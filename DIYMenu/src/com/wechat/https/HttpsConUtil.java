package com.wechat.https;

/**
 * 对URL的请求进行封装
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.wechat.create_menu.CreateMenu;
import com.wechat.myX509TureManager.MyX509TureManager;

public class HttpsConUtil {

	public static String request(String Url, String Method, String econding) {

		CreateMenu createMenu = new CreateMenu();
		HttpsURLConnection httpsURLConnection = null;

		StringBuilder stringBuilder = null;
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

			// 写入流，将json格式的菜单写入微信服务器
			OutputStream outputStream = httpsURLConnection.getOutputStream();
			outputStream.write(createMenu.getMenuJson().getBytes(econding));
			// System.out.println(createMenu.getMenuJson());
			outputStream.close();

			/**
			 * 网页读取
			 */
			// 设置流,读取返回信息
			BufferedReader bufferedReader = new BufferedReader(
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

		// 返回json的数据
		return stringBuilder.toString();
	}
	
}

