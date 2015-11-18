package vegaro.msw.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import javax.inject.Inject;

import vegaro.msw.AndroidApplication;
import vegaro.msw.CustomJsonRequest;
import vegaro.msw.R;

public class MainActivity extends BaseActivity {
    @Inject RequestQueue requestQueue;
    TextView mTxtDegrees, mTxtWeather, mTxtError;
    final static String RECENT_API_ENDPOINT = "http://marsweather.ingenology.com/v1/latest/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AndroidApplication) getApplication()).getNetComponent().inject(this);
        setContentView(R.layout.activity_main);
        mTxtDegrees = (TextView) findViewById(R.id.degrees);
        mTxtWeather = (TextView) findViewById(R.id.weather);
        mTxtError = (TextView) findViewById(R.id.error);
        loadWeatherData();
    }

    private void loadWeatherData() {
            CustomJsonRequest request = new CustomJsonRequest
                    (Request.Method.GET, RECENT_API_ENDPOINT, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            try {

                                String minTemp, maxTemp, atmo;
                                int avgTemp;

                                response = response.getJSONObject("report");

                                minTemp = response.getString("min_temp"); minTemp = minTemp.substring(0, minTemp.indexOf("."));
                                maxTemp = response.getString("max_temp"); maxTemp = maxTemp.substring(0, maxTemp.indexOf("."));

                                avgTemp = (Integer.parseInt(minTemp)+Integer.parseInt(maxTemp))/2;

                                atmo = response.getString("atmo_opacity");


                                mTxtDegrees.setText(avgTemp+"°");
                                mTxtWeather.setText(atmo);

                            } catch (Exception e) {
                                txtError(e);
                            }

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            txtError(error);
                        }
                    });

            request.setPriority(Request.Priority.HIGH);
            request.setTag(AndroidApplication.class.getName());
            requestQueue.add(request);

        }

    private void txtError(Exception e) {
        mTxtError.setVisibility(View.VISIBLE);
        e.printStackTrace();
    }
}
