package com.dstyo.prelo.utils;

import android.support.test.InstrumentationRegistry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.08.12
 */
public class TestUtils {
    public TestUtils() {
    }

    public static String readAsset(final String file) throws RuntimeException {
        StringBuilder builder = new StringBuilder();

        try {
            InputStream inputStream = InstrumentationRegistry.getContext().getAssets().open(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            String str;
            while (null != (str = reader.readLine())) {
                builder.append(str);
            }
            reader.close();
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
