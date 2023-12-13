package com.dodo.httpclient;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author lwh
 * @date 2023-12-13 20:00:10
 * @describe --
 */
public class HttpClientUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

    public static CloseableHttpClient httpClient;

    // ms
    private final static long CONNECT_TIME_OUT = 5000L;

    // ms
    private final static int SOCKET_TIME_OUT = 5000;

    // 最大打开连接总数
    private final static int POOL_MAX_TOTAL = 10;

    // 设置每个路由的最大并发连接数，默认为 2
    private final static int POOL_DEFAULT_MAX_PER_ROUTE = 10;

    static {
        LOGGER.info(">>>>>>>>>> init httpclient >>>>>>>>>>");
        // 设置超时时间
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setConnectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .setSocketTimeout(SOCKET_TIME_OUT, TimeUnit.MILLISECONDS)
                .build();

        try {
            httpClient = HttpClients.custom()
                    .setConnectionManager(getHttpClientConnectionManager(connectionConfig))
                    .build();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String url) {
        return get(url, null, null);
    }

    public static String get(String url, Map<String, Object> params) {
        return get(url, null, params);
    }

    public static String get(String url, Map<String, Object> headers, Map<String, Object> params) {
        HttpGet httpGet = new HttpGet(url);
        if (Objects.nonNull(headers) && headers.size() > 0) {
            headers.forEach(httpGet::addHeader);
        }
        if (Objects.nonNull(params) && params.size() > 0) {
            List<NameValuePair> nameValuePairList = new ArrayList<>();
            params.forEach((k, v) -> nameValuePairList.add(new BasicNameValuePair(k, String.valueOf(v))));
            try {
                URI uri = new URIBuilder(new URI(url)).addParameters(nameValuePairList).build();
                httpGet.setUri(uri);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            return httpClient.execute(httpGet, response -> {
                HttpEntity entity = response.getEntity();
                String resStr = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
                return resStr;
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpClientConnectionManager getHttpClientConnectionManager(ConnectionConfig connectionConfig) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(getRegistryConnectionSocketFactory());
        connectionManager.setMaxTotal(POOL_MAX_TOTAL);
        connectionManager.setDefaultMaxPerRoute(POOL_DEFAULT_MAX_PER_ROUTE);
        connectionManager.setDefaultConnectionConfig(connectionConfig);
        return connectionManager;
    }

    private static Registry<ConnectionSocketFactory> getRegistryConnectionSocketFactory() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        // 创建自定义的 TrustStrategy 来忽略 SSL 证书
        final TrustStrategy trustStrategy = (cert, authType) -> true;

        // 使用自定义的 TrustStrategy 来创建 SSLContext
        final SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial(null, trustStrategy)
                .build();
        final SSLConnectionSocketFactory sslConnectionSocketFactory =
                new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

        return RegistryBuilder.<ConnectionSocketFactory>create()
                .register("https", sslConnectionSocketFactory)
                .register("http", new PlainConnectionSocketFactory())
                .build();
    }
}

