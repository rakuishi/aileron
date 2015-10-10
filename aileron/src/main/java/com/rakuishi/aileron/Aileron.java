package com.rakuishi.aileron;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

import com.rakuishi.aileron.annotations.Extra;

import java.lang.reflect.Field;

public final class Aileron {

    private Aileron() {}

    public static void roll(Activity target) {
        roll(target, target.getIntent().getExtras());
    }

    public static void roll(Fragment target) {
        roll(target, target.getArguments());
    }

    public static void roll(android.support.v4.app.Fragment target) {
        roll(target, target.getArguments());
    }

    public static void roll(Object target, Bundle extras) {
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
                e.printStackTrace();
            }
        }
    }

    public static void setValue(Object target, Field field, Bundle extras, String key)
            throws IllegalAccessException {

        String clazz = field.getGenericType().toString();

        switch (clazz) {
            case "byte":
                field.setByte(target, extras.getByte(key));
                break;
            case "short":
                field.setShort(target, extras.getShort(key));
                break;
            case "int":
                field.setInt(target, extras.getInt(key));
                break;
            case "long":
                field.setLong(target, extras.getLong(key));
                break;
            case "float":
                field.setFloat(target, extras.getFloat(key));
                break;
            case "double":
                field.setDouble(target, extras.getDouble(key));
                break;
            case "char":
                field.setChar(target, extras.getChar(key));
                break;
            case "boolean":
                field.setBoolean(target, extras.getBoolean(key));
                break;
            case "class [B":
                field.set(target, extras.getByteArray(key));
                break;
            case "class [S":
                field.set(target, extras.getShortArray(key));
                break;
            case "class [I":
                field.set(target, extras.getIntArray(key));
                break;
            case "class [J":
                field.set(target, extras.getLongArray(key));
                break;
            case "class [F":
                field.set(target, extras.getFloatArray(key));
                break;
            case "class [D":
                field.set(target, extras.getDoubleArray(key));
                break;
            case "class [C":
                field.set(target, extras.getCharArray(key));
                break;
            case "class [Z":
                field.set(target, extras.getBooleanArray(key));
                break;
            case "class java.lang.Byte":
            case "class java.lang.Short":
            case "class java.lang.Integer":
            case "class java.lang.Long":
            case "class java.lang.Float":
            case "class java.lang.Double":
            case "class java.lang.Character":
            case "class java.lang.Boolean":
                field.set(target, extras.get(key));
                break;
            case "java.util.List<java.lang.Integer>":
                field.set(target, extras.getIntegerArrayList(key));
                break;
            case "class java.lang.String":
                field.set(target, extras.getString(key));
                break;
            case "class [Ljava.lang.String;":
                field.set(target, extras.getStringArray(key));
                break;
            case "java.util.List<java.lang.String>":
                field.set(target, extras.getStringArrayList(key));
                break;
            case "class android.os.Bundle":
                field.set(target, extras.getBundle(key));
                break;
            case "interface java.lang.CharSequence":
                field.set(target, extras.getCharSequence(key));
                break;
            case "class [Ljava.lang.CharSequence;":
                field.set(target, extras.getCharArray(key));
                break;
            case "java.util.ArrayList<java.lang.CharSequence>":
                field.set(target, extras.getCharSequenceArrayList(key));
                break;
            case "class android.util.Size":
                if (isLollipop()) {
                    field.set(target, extras.getSize(key));
                }
                break;
            case "class android.util.SizeF":
                if (isLollipop()) {
                    field.set(target, extras.getSizeF(key));
                }
                break;
        }
    }

    private static boolean isLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }
}
