package vegaro.msw.di.modules;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vegaro on 16/11/15.
 */
@Module
public class NetModule {
    public NetModule () {

    }
    @Provides
    @Singleton
    RequestQueue providesRequestQueue(Application application) {
        return Volley.newRequestQueue(application);
    }
}
