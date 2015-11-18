package vegaro.msw.di.modules;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import vegaro.msw.AndroidApplication;

/**
 * Created by vegaro on 16/11/15.
 */
@Module
public class ApplicationModule {
    Application application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides @Singleton Application providesApplication() {
        return this.application;
    }
}
