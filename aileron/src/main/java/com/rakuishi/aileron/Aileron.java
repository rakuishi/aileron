package com.rakuishi.aileron;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.rakuishi.aileron.annotations.Extra;

import java.lang.reflect.Field;

public final class Aileron {

    private Aileron() {}

    public static void roll(Activity target) {
        Bundle extras = target.getIntent().getExtras();
        if (extras == null) {
            return;
        }

        for (Field field: target.getClass().getDeclaredFields()) {
            Extra extra = field.getAnnotation(Extra.class);
            if (extra == null) {
                continue;
            }

            try {
                field.setAccessible(true);
                setValue(target, field, extras, extra.value());
            } catch (SecurityException | IllegalAccessException e) {
                LOGD(e.getMessage());
            }
        }
    }

    public static void setValue(Activity target, Field field, Bundle extras, String key)
            throws IllegalAccessException {

        if (field.getType().equals(int.class)) {
            field.setInt(target, extras.getInt(key));
        }
    }

    public static void LOGD(String message) {
        Log.d(Aileron.class.getSimpleName(), message);
    }
}
