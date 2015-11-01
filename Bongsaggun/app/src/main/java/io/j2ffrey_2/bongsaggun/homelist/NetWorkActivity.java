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

// 엑티비티는 라이프 사이클에 걸려있는거니까
    //죽었어 --> 네트워크를 가지고 오지 못하니까
    //android asynchTask는 이제 쓰레드를 만들었음


    //여기에 파서를 넣읍시다.
public class NetWorkActivity {
    private String urlst = "https://dosomething-j2ffrey-2.c9.io/json/filter";
    private String results = null;
    String sum = null;
    String s = null;
    NetworkConnector connector;
    String [][] parseddata;
    // 할것 : 연결안된거 예외처리 만들어주기
    public void LoadAPI (String urls)
    {
        urlst = urls;
        connector = new NetworkConnector();
        connector.execute();
    }
    public String[][] getResult() {
        //String s =connector.getResult();
        return parseddata;
    }
    public class NetworkConnector extends AsyncTask<String, Void, String>
    {
        public NetworkConnector(){

        }

        @Override
        protected String doInBackground(String... params) {
            sum = "";
            try {
                URL url = new URL(urlst);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                //추가설정
                conn.setUseCaches(false);
                conn.setDoInput(true);

                InputStreamReader streamReader = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader rd = new BufferedReader(streamReader);

                StringBuilder builder = new StringBuilder();
                String data;

                while ((data = rd.readLine()) != null)
                {
                    builder.append(data);
                }
                sum = builder.toString();

                Log.i("sum",sum);
                //받아온 데이터를 파서로 보내서 파싱해준다
                JsonParser parser = new JsonParser();
//                parseddata = parser.jsonParserList(sum);
            }
            catch (IOException e)
            {
            }
            Log.i("NetworkConnector", sum);

            return sum;
        }
        public String getResult() {
            return sum;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if(result != null){
                Log.d("ASYNC", "result = " + result);
                sum = result;
            }
        }



        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }

}


