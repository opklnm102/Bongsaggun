package io.j2ffrey_2.bongsaggun.homelist;


import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by vantovan on 2015. 10. 31..
 */
public class NetWorkActivity {
    static final String urlst = "https://dosomething-j2ffrey-2.c9.io/json/filter";
    static String results = null;

    // 할것 : 연결안된거 예외처리 만들어주기

    public void LoadAPI ()
    {
        NetworkConnector connector = new NetworkConnector();

        connector.execute();
    }

    public String getResult() {
        return results;
    }


    public class NetworkConnector extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... params) {
            String sum = "";
            try {
                URL url = new URL(urlst);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                InputStreamReader streamReader = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader rd = new BufferedReader(streamReader);

                StringBuilder builder = new StringBuilder();
                String data;

                while ((data = rd.readLine()) != null)
                {
                    builder.append(data);
                }

                sum = builder.toString();
            }
            catch (IOException e)
            {

            }

            Log.i("NetworkConnector", sum);

            return sum;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if(result != null){
                Log.d("ASYNC", "result = " + result);
                results = result;
            }
        }



        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }
}


