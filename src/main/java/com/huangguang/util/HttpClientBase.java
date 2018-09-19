package com.huangguang.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.*;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.LineParser;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.CharArrayBuffer;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.InetAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.*;


/**
 * 
 * @author Administrator
 *
 */
public abstract class HttpClientBase {
	

    public static final String DEFAULT_CHARSET_ENCODING = "UTF-8";
    private static final int CONNECTION_REQUEST_TIMEOUT = 5 * 60 * 1000;
    private static final int CONNECT_TIMEOUT = 5 * 60 * 1000;
    private static final int SOCKET_TIMEOUT = 5 * 60 * 1000;

    protected static String doHttpGet(URI uri, HttpClient httpClient, String charsetEncoding, Integer connectTimeout) {
        HttpGet httpGet = new HttpGet(uri);
        try {
            //设置超时时间
            if (connectTimeout != null) {
                RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(connectTimeout).setConnectTimeout(connectTimeout).build();
                httpGet.setConfig(requestConfig);
            }
            HttpResponse httpResponse = httpClient.execute(httpGet);
            InputStream in = httpResponse.getEntity().getContent();
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, charsetEncoding));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                sb.append(line);
            }
            in.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
        }
    }


    protected static String doHttpPost(URI uri, CloseableHttpClient httpClient, List<NameValuePair> nvps, String charsetEncoding, Integer connectTimeout) {
        HttpPost httpPost = new HttpPost(uri);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, charsetEncoding));
            //设置超时时间
            if (connectTimeout != null) {
                RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(connectTimeout).build();
                httpPost.setConfig(requestConfig);
            }
            HttpResponse httpResponse = httpClient.execute(httpPost);
            InputStream in = httpResponse.getEntity().getContent();
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, charsetEncoding));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                sb.append(line);
            }
            in.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
        }
    }


    protected static String doHttpPost(URI uri, HttpClient httpClient, List<NameValuePair> nvps, String charsetEncoding, Integer connectTimeout) {
        HttpPost httpPost = new HttpPost(uri);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, charsetEncoding));
            //设置超时时间
            if (connectTimeout != null) {
                RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(connectTimeout).build();
                httpPost.setConfig(requestConfig);
            }

            HttpResponse httpResponse = httpClient.execute(httpPost);
            InputStream in = httpResponse.getEntity().getContent();
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, charsetEncoding));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                sb.append(line);
            }
            in.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
        }
    }

    protected static String doJsonPost(URI uri, HttpClient httpClient, String json, String charsetEncoding, Integer connectTimeout) {
        HttpPost httpPost = new HttpPost(uri);
        try {
            StringEntity stringEntity = new StringEntity(json, charsetEncoding);
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            //设置超时时间
            if (connectTimeout != null) {
                RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(connectTimeout).build();
                httpPost.setConfig(requestConfig);
            }
            HttpResponse httpResponse = httpClient.execute(httpPost);
            InputStream in = httpResponse.getEntity().getContent();
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, charsetEncoding));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                sb.append(line);
            }
            in.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
        }
    }

    protected static String doXmlPost(URI uri, HttpClient httpClient, String json, String charsetEncoding, Integer connectTimeout) {
        HttpPost httpPost = new HttpPost(uri);
        try {
            StringEntity stringEntity = new StringEntity(json, charsetEncoding);
            stringEntity.setContentType("application/xml");
            httpPost.setEntity(stringEntity);
            //设置超时时间
            if (connectTimeout != null) {
                RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(connectTimeout).build();
                httpPost.setConfig(requestConfig);
            }
            HttpResponse httpResponse = httpClient.execute(httpPost);
            InputStream in = httpResponse.getEntity().getContent();
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, charsetEncoding));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                sb.append(line);
            }
            in.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
        }
    }
    

    protected static String xmlPostProxy(URI uri, String json, String charsetEncoding, Integer connectTimeout, String proxyHost, Integer proxyPort) {
        HttpMessageParserFactory<HttpResponse> responseParserFactory = new DefaultHttpResponseParserFactory() {
            public HttpMessageParser<HttpResponse> create(SessionInputBuffer buffer, MessageConstraints constraints) {
                LineParser lineParser = new BasicLineParser() {
                    public Header parseHeader(final CharArrayBuffer buffer) {
                        try {
                            return super.parseHeader(buffer);
                        } catch (ParseException ex) {
                            return new BasicHeader(buffer.toString(), null);
                        }
                    }
                };
                return new DefaultHttpResponseParser(buffer, lineParser, DefaultHttpResponseFactory.INSTANCE, constraints) {
                    protected boolean reject(final CharArrayBuffer line, int count) {
                        return false;
                    }

                };
            }

        };
        HttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();
        HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
                requestWriterFactory, responseParserFactory);
        SSLContext sslcontext = SSLContexts.createSystemDefault();
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(sslcontext))
                .build();
        DnsResolver dnsResolver = new SystemDefaultDnsResolver() {
            public InetAddress[] resolve(final String host) throws UnknownHostException {
                if (host.equalsIgnoreCase("myhost")) {
                    return new InetAddress[]{InetAddress.getByAddress(new byte[]{127, 0, 0, 1})};
                } else {
                    return super.resolve(host);
                }
            }
        };
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(
                socketFactoryRegistry, connFactory, dnsResolver);
        //设置连接汿
        connManager.setMaxTotal(1500);

        connManager.setDefaultMaxPerRoute(400);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connManager)
                .setProxy(new HttpHost(proxyHost, proxyPort))//设置代理,如果没有关闭 则关闭代琿
                .build();
        return doJsonPost(uri, httpClient, json, charsetEncoding, connectTimeout);
    }



    /**
     * 设置是否代理请求
     *
     * @param uri
     * @param params
     * @param charsetEncoding
     * @param proxyHost
     * @param proxyPort
     * @return
     */
    protected static String httpPostProxy(URI uri, Map<String, String> params, String charsetEncoding, Integer connectTimeout, String proxyHost, Integer proxyPort) {
        HttpMessageParserFactory<HttpResponse> responseParserFactory = new DefaultHttpResponseParserFactory() {
            public HttpMessageParser<HttpResponse> create(SessionInputBuffer buffer, MessageConstraints constraints) {
                LineParser lineParser = new BasicLineParser() {
                    public Header parseHeader(final CharArrayBuffer buffer) {
                        try {
                            return super.parseHeader(buffer);
                        } catch (ParseException ex) {
                            return new BasicHeader(buffer.toString(), null);
                        }
                    }
                };


                return new DefaultHttpResponseParser(buffer, lineParser, DefaultHttpResponseFactory.INSTANCE, constraints) {
                    protected boolean reject(final CharArrayBuffer line, int count) {
                        return false;
                    }

                };
            }

        };
        HttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();
        HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
                requestWriterFactory, responseParserFactory);
        SSLContext sslcontext = SSLContexts.createSystemDefault();
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(sslcontext))
                .build();
        DnsResolver dnsResolver = new SystemDefaultDnsResolver() {
            public InetAddress[] resolve(final String host) throws UnknownHostException {
                if (host.equalsIgnoreCase("myhost")) {
                    return new InetAddress[]{InetAddress.getByAddress(new byte[]{127, 0, 0, 1})};
                } else {
                    return super.resolve(host);
                }
            }
        };
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(
                socketFactoryRegistry, connFactory, dnsResolver);
        //设置连接汿
        connManager.setMaxTotal(1500);

        connManager.setDefaultMaxPerRoute(400);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setConnectionManager(connManager)
                .setProxy(new HttpHost(proxyHost, proxyPort))//设置代理,如果没有关闭 则关闭代琿
                .build();
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            nvps.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        return doHttpPost(uri, httpclient, nvps, charsetEncoding, connectTimeout);
    }

    protected static String jsonPostProxy(URI uri, String json, String charsetEncoding, Integer connectTimeout, String proxyHost, Integer proxyPort) {
        HttpMessageParserFactory<HttpResponse> responseParserFactory = new DefaultHttpResponseParserFactory() {
            public HttpMessageParser<HttpResponse> create(SessionInputBuffer buffer, MessageConstraints constraints) {
                LineParser lineParser = new BasicLineParser() {
                    public Header parseHeader(final CharArrayBuffer buffer) {
                        try {
                            return super.parseHeader(buffer);
                        } catch (ParseException ex) {
                            return new BasicHeader(buffer.toString(), null);
                        }
                    }
                };
                return new DefaultHttpResponseParser(buffer, lineParser, DefaultHttpResponseFactory.INSTANCE, constraints) {
                    protected boolean reject(final CharArrayBuffer line, int count) {
                        return false;
                    }

                };
            }

        };
        HttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();
        HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
                requestWriterFactory, responseParserFactory);
        SSLContext sslcontext = SSLContexts.createSystemDefault();
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(sslcontext))
                .build();
        DnsResolver dnsResolver = new SystemDefaultDnsResolver() {
            public InetAddress[] resolve(final String host) throws UnknownHostException {
                if (host.equalsIgnoreCase("myhost")) {
                    return new InetAddress[]{InetAddress.getByAddress(new byte[]{127, 0, 0, 1})};
                } else {
                    return super.resolve(host);
                }
            }
        };
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(
                socketFactoryRegistry, connFactory, dnsResolver);
        //设置连接汿
        connManager.setMaxTotal(1500);

        connManager.setDefaultMaxPerRoute(400);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connManager)
                .setProxy(new HttpHost(proxyHost, proxyPort))//设置代理,如果没有关闭 则关闭代琿
                .build();
        return doJsonPost(uri, httpClient, json, charsetEncoding, connectTimeout);
    }

    protected static String httpGet(String url, Map<String, String> params, String charsetEncoding, Integer connectTimeout) {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            nvps.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        String paramString = URLEncodedUtils.format(nvps, charsetEncoding);
        return httpGet(URI.create(url + "?" + paramString), charsetEncoding, connectTimeout);
    }
    
    public static String httpGet(URI uri, String charsetEncoding, Integer connectTimeout) {
        HttpClient httpClient = HttpClients.createDefault();
        return doHttpGet(uri, httpClient, charsetEncoding, connectTimeout);
    }

    
    public static String sslHttpGet(URI uri, String charsetEncoding, Integer connectTimeout) {
        HttpClient httpClient = createHttpsClient();
        return doHttpGet(uri, httpClient, charsetEncoding, connectTimeout);
    }

    protected static String httpPost(URI uri, Map<String, String> params, String charsetEncoding, Integer connectTimeout) {
        HttpClient httpClient = HttpClients.createDefault();
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            nvps.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        return doHttpPost(uri, httpClient, nvps, charsetEncoding, connectTimeout);
    }

    public static String sslHttpGet(String url, Map<String, String> params, String charsetEncoding, Integer connectTimeout) {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            nvps.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        String paramString = URLEncodedUtils.format(nvps, charsetEncoding);
        return sslHttpGet(URI.create(url + "?" + paramString), charsetEncoding, connectTimeout);
    }


    protected static CloseableHttpClient createHttpsClient() {
        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            // set up a TrustManager that trusts everything
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs,   String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }}, new SecureRandom());
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }



    protected static String sslHttpPost(URI uri, Map<String, String> params, String charsetEncoding, Integer connectTimeout) {
        HttpClient httpClient = createHttpsClient();
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            nvps.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        return doHttpPost(uri, httpClient, nvps, charsetEncoding, connectTimeout);
    }

    /**
     * @param request
     * @return
     * @category 获取request参数
     */
    public static Map<String, String> request2Map(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String name = enums.nextElement();
            String value = request.getParameter(name);
            if (request.getParameterValues(name) != null) {
                value = StringUtils.join(request.getParameterValues(name), ",");
            }
            map.put(name, value);
        }
        return map;
    }

    public static String getInfoFromRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        StringBuffer info = new StringBuffer();
        InputStream in = null;
        try {
            in = request.getInputStream();
            BufferedInputStream buf = new BufferedInputStream(in);
            byte[] buffer = new byte[1024];
            int iRead;
            while ((iRead = buf.read(buffer)) != -1) {
                info.append(new String(buffer, 0, iRead, "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        //logger.info("接受信息="+info.toString());
        return URLDecoder.decode(info.toString(), "UTF-8");
    }
}
