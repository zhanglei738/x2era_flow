package com.x2era.flow.common;

import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created on 2019/9/11 11:15 AM
 * 跳过SSL安全认证
 *
 * @author shuke
 * @version 0.1
 **/
@Slf4j
public final class SSLUtil {
    static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    } };
    public static void turnOffSslChecking() {
        try{
            HttpsURLConnection.setDefaultHostnameVerifier(new NullHostNameVerifier());
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        }catch (Exception e){
            log.info("SSLUtil.turnOffSslChecking");
        }
    }
    public static void turnOnSslChecking() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext.getInstance("SSL").init(null, null, null);
    }
    private SSLUtil() {
        throw new UnsupportedOperationException("Do not instantiate libraries.");
    }
    public static class NullHostNameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String arg0, SSLSession arg1) {
            return true;
        }
    }

}