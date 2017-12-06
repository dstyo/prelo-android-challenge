package com.dstyo.prelo.dagger.component;

import com.dstyo.prelo.activity.login.LoginActivity;
import com.dstyo.prelo.dagger.module.AppModule;
import com.dstyo.prelo.dagger.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(LoginActivity loginActivity);
}
