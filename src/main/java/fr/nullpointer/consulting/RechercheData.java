package fr.nullpointer.consulting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class RechercheData {
    public String siteApi = "http://google.fr"; //variable de l'url de l'api

    public void funcRecherche() throws IOException {

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
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = " ";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }

    }

}