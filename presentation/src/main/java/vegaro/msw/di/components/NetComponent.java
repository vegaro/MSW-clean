package vegaro.msw.di.components;

import javax.inject.Singleton;

import dagger.Component;
import vegaro.msw.di.modules.ApplicationModule;
import vegaro.msw.di.modules.NetModule;
import vegaro.msw.view.activity.MainActivity;

/**
 * Created by vegaro on 16/11/15.
 */
@Singleton
@Component(modules={ApplicationModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
}
