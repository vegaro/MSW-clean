package vegaro.msw.di.components;

import android.app.Application;

import com.android.volley.RequestQueue;

import javax.inject.Singleton;

import dagger.Component;
import vegaro.msw.di.modules.ApplicationModule;
import vegaro.msw.view.activity.BaseActivity;

/**
 * Created by vegaro on 16/11/15.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);
}