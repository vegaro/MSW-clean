package vegaro.msw;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import javax.inject.Inject;

import vegaro.msw.di.components.ApplicationComponent;
import vegaro.msw.di.components.DaggerApplicationComponent;

import vegaro.msw.di.components.NetComponent;
import vegaro.msw.di.components.DaggerNetComponent;

import vegaro.msw.di.modules.ApplicationModule;
import vegaro.msw.di.modules.NetModule;

/**
 * Created by vegaro on 16/11/15.
 */
public class AndroidApplication extends Application {
    public static final String TAG = AndroidApplication.class.getName();
    private NetComponent netComponent;

    @Override public void onCreate() {
        super.onCreate();
        netComponent =
                DaggerNetComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .netModule(new NetModule()).build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
