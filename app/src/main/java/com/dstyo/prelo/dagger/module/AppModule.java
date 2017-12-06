package com.dstyo.prelo.dagger.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.07.12
 */
@Module
public class AppModule {
    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public Context providesContext() {
        return context;
    }
}
