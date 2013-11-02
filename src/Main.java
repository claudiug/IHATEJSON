
import sun.net.www.content.text.plain;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.logging.Logger;

public class Main {
    static JSONObject resultObj;

    public static JSONObject getJSON(String url, int timeout ) {
        try {
            URL u = new URL(url);
            HttpURLConnection c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(timeout);
            c.setReadTimeout(timeout);
            c.connect();
            int status = c.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");


                    }
                    br.close();
                    resultObj = new JSONObject(sb.toString());

            }

        } catch (MalformedURLException ex) {

        } catch (IOException ex) {

        }
        return resultObj;
    }

    public static void main(String[] args) throws IOException {
        String site = "https://www.drive-now.com/php/metropolis/json.vehicle_filter?cit=6099";
        JSONObject object = getJSON(site, 2000);
        JSONObject rec = (JSONObject) object.get("rec");
        System.out.println(rec.has("vehicles"));
        JSONObject jsonObject = rec.getJSONObject("vehicles");
        JSONArray result = jsonObject.getJSONArray("vehicles");
        System.out.println(result.getClass());
        for (int i = 0; i < result.length(); i++) {
            System.out.println(result.getJSONObject(i).getString("carName"));
            System.out.println("LAT " + result.getJSONObject(i).getJSONObject("position").get("latitude"));
            System.out.println("LGN " + result.getJSONObject(i).getJSONObject("position").get("longitude"));
        }


    }
}
