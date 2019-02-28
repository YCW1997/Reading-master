package com.yuan.reading.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.yuan.reading.MyApplication;


public class SPUtils {

    private static SharedPreferences mPrefs;
    private static String defaultFileName = "config";

    private static Context getContext() {
        return MyApplication.context;
    }

    public static void put(String key, Object value) {
        put(key, value, null);
    }

    public static void put(String key, Object value, String newFileName) {
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);

        if (value == null) {
            remove(key, newFileName);
            return;
        }

        if (value instanceof Boolean) {
            mPrefs.edit().putBoolean(key, (Boolean) value).apply();
        } else if (value instanceof Integer) {
            mPrefs.edit().putInt(key, (Integer) value).apply();
        } else if (value instanceof Long) {
            mPrefs.edit().putLong(key, (Long) value).apply();
        } else if (value instanceof String) {
            mPrefs.edit().putString(key, (String) value).apply();
        } else if (value instanceof Float) {
            mPrefs.edit().putFloat(key, (Float) value).apply();
        } else if (value instanceof Double) {
            mPrefs.edit().putString(key, String.valueOf(value)).apply();
        } else {
            mPrefs.edit().putString(key, new Gson().toJson(value)).apply();
        }
    }

    public static boolean put(String key, String value, String newFileName) {
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);

        if (value == null) {
            return false;
        }
        return mPrefs.edit().putString(key, value).commit();
    }

    public static Long getLong(String key, long value) {
        return getLong(key, value, null);
    }

    public static Long getLong(String key, long value, String newFileName) {
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        return mPrefs.getLong(key, value);
    }

    public static float getFloat(String key, float value) {
        return getFloat(key, value, null);
    }

    public static float getFloat(String key, float value, String newFileName) {
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        return mPrefs.getFloat(key, value);
    }

    public static double getDouble(String key, double value) {
        return getDouble(key, value, null);
    }

    public static double getDouble(String key, double value, String newFileName) {
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        return Double.valueOf(mPrefs.getString(key, String.valueOf(value)));
    }

    public static boolean getBoolean(String key, boolean value) {
        return getBoolean(key, value, null);
    }

    public static boolean getBoolean(String key, boolean value, String newFileName) {
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        return mPrefs.getBoolean(key, value);
    }

    public static String getString(String key, String value) {
        return getString(key, value, null);
    }

    public static String getString(String key, String value, String newFileName) {
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        return mPrefs.getString(key, value);
    }

    public static Integer getInt(String key, int value) {
        return getInt(key, value, null);
    }

    public static Integer getInt(String key, int value, String newFileName) {
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        return mPrefs.getInt(key, value);
    }

    public static <T> T getObject(String key, Class<T> clazz) {
        return getObject(key, clazz, null, null);
    }

    public static <T> T getObject(String key, Class<T> clazz, T value) {
        return getObject(key, clazz, value, null);
    }

    public static <T> T getObject(String key, Class<T> clazz, String newFileName) {
        return getObject(key, clazz, null, newFileName);
    }

    public static <T> T getObject(String key, Class<T> clazz, T value, String newFileName) {
        try {
            mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
            String json = mPrefs.getString(key, null);
            if (TextUtils.isEmpty(json)) {
                return value;
            } else {

                return new Gson().fromJson(json, clazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void remove(String name) {
        remove(name, null);
    }

    public static void remove(String name, String newFileName) {
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        mPrefs.edit().remove(name).apply();
    }

    public static boolean clear(String newFileName) {
        if (newFileName != null && !newFileName.isEmpty()) {
            mPrefs = getContext().getSharedPreferences(newFileName, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.clear();
            return editor.commit();
        }
        return false;
    }

    public static boolean contains(String key) {
        return contains(key, null);
    }

    public static boolean contains(String key, String newFileName) {
        mPrefs = getContext().getSharedPreferences(newFileName != null ? newFileName : defaultFileName, Context.MODE_PRIVATE);
        return mPrefs.contains(key);
    }


}