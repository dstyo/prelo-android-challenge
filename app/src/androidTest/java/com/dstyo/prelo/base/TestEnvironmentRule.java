package com.dstyo.prelo.base;

import android.support.test.InstrumentationRegistry;

import com.dstyo.prelo.BaseApplication;
import com.dstyo.prelo.dagger.component.DaggerAppComponent;
import com.dstyo.prelo.dagger.module.AppModule;
import com.dstyo.prelo.dagger.module.NetworkModule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.08.12
 */
public class TestEnvironmentRule implements TestRule {
    public static final String DOMAIN = MockWebServerTestRule.DOMAIN;
    public static final int PORT = MockWebServerTestRule.PORT;

    public static String domain() {
        return String.format("http://%s:%s", DOMAIN, PORT);
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new TestEnvironmentStatement(base);
    }

    private static class TestEnvironmentStatement extends Statement {

        private Statement baseStatement;

        public TestEnvironmentStatement(Statement baseStatement) {
            this.baseStatement = baseStatement;
        }

        @Override
        public void evaluate() throws Throwable {
            BaseApplication baseApp = (BaseApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();
            String mainServer = String.format("%s", domain());
            baseApp.setAppComponent(
                    DaggerAppComponent
                            .builder()
                            .appModule(new AppModule(InstrumentationRegistry.getTargetContext()))
                            .networkModule(new NetworkModule(mainServer))
                            .build()
            );
            baseStatement.evaluate();
        }
    }
}
