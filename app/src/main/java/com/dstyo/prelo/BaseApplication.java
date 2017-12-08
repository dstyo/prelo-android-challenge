package com.dstyo.prelo;

import android.app.Application;

import com.dstyo.prelo.dagger.component.AppComponent;
import com.dstyo.prelo.dagger.component.DaggerAppComponent;
import com.dstyo.prelo.dagger.module.AppModule;
import com.dstyo.prelo.dagger.module.NetworkModule;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
public class BaseApplication extends Application{
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setAppComponent(DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(BuildConfig.BASEURL))
                .build());
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public void setAppComponent(AppComponent mAppComponent) {
        this.mAppComponent = mAppComponent;
    }

}
