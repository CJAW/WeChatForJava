package com.wechat.myX509TureManager;


/**
 * 管理https的证书ß
 */
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class MyX509TureManager implements javax.net.ssl.X509TrustManager{

	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}

}
