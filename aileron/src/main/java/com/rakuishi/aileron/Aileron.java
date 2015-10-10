package com.rakuishi.aileron;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

import com.rakuishi.aileron.annotations.Extra;

import java.lang.reflect.Field;

public final class Aileron {

    private Aileron() {}

    public static void roll(Activity target) {
        Bundle extras = target.getIntent().getExtras();
        if (extras != null) {
            roll(target, extras);
        }
    }

    public static void roll(Fragment target) {
        Bundle extras = target.getArguments();
        if (extras != null) {
            roll(target, extras);
        }
    }

    public static void roll(android.support.v4.app.Fragment target) {
        Bundle extras = target.getArguments();
        if (extras != null) {
            roll(target, extras);
        }
    }

    public static void roll(Object target, Bundle extras) {
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

    public static void setValue(Object target, Field field, Bundle extras, String key)
            throws IllegalAccessException {

        if (field.getType().equals(int.class)) {
            field.setInt(target, extras.getInt(key));
        } else if (field.getType().equals(String.class)) {
            field.set(target, extras.getString(key));
        }
    }

    public static void LOGD(String message) {
        Log.d(Aileron.class.getSimpleName(), message);
    }
}
