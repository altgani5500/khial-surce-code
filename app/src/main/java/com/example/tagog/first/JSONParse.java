package com.example.tagog.first;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.List;


/**
 * Created by Bassam on 10/20/2014.
 */
public class JSONParse {

    public JSONObject makeHttpRequest(String url, List<NameValuePair> pairs)
    {
        try
        {
            HttpParams httpParams = new BasicHttpParams();

            int timeoutConnection = 10000;
            HttpConnectionParams.setConnectionTimeout(httpParams, timeoutConnection);
            //HttpConnectionParamBean


            int timeoutSocket = 10000;
            HttpConnectionParams.setConnectionTimeout(httpParams, timeoutSocket);

            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(httpParams);
           // DefaultHttpClientConnection
            HttpPost httpPost = new HttpPost(url);

            if (pairs != null)
            {
                httpPost.setEntity(new UrlEncodedFormEntity(pairs));
            }

            HttpResponse httpResponse = defaultHttpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();

            if (httpEntity != null)
            {
                String ret = EntityUtils.toString(httpEntity);
                return new JSONObject(ret.substring(ret.indexOf("{"), ret.lastIndexOf("}") + 1));
            }
        }
        catch (Exception ex)
        {

        }
        return null;
    }
}
