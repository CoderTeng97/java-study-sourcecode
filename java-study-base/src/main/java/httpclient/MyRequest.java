package httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyRequest {

    public static void post() throws IOException {
        HttpGet httpGet = new HttpGet("https://blog.csdn.net/lucklyming/article/details/84525526");
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        CloseableHttpResponse closeableHttpResponse =  closeableHttpClient.execute(httpGet);
        HttpEntity httpEntity = closeableHttpResponse.getEntity();
        httpEntity.getContent();
        String result = EntityUtils.toString(httpEntity, Charset.defaultCharset());
        System.out.println(result);
    }

    public static void main(String[] arg) throws IOException {
         post();
    }
}
