package fr.nullpointer.consulting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class RechercheData {
    public String siteApi = "https://api.nasa.gov/neo/rest/v1/feed?start_date=2019-01-01&end_date=2019-01-06&api_key=DEMO_KEY"; //variable de l'url de l'api

    public String funcRecherche() throws IOException {


        //java fonction client api rest

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(siteApi);
        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Warning!");
        }
        InputStream monInputStream = response.getEntity().getContent();
        String encoding = null;

        return IOUtils.toString(monInputStream, encoding);
    }

}