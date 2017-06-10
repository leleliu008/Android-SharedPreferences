package com.fpliu.newton.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;

/**
 * 设置的具体实现
 *
 * @author 792793182@qq.com.com 2014-9-29
 */
final class SettingImpl implements ISetting {

    private SharedPreferences mSharedPref;

    public SettingImpl(Context context, String name) {
        mSharedPref = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    @Override
    public boolean exist(String key) {
        return mSharedPref.contains(key);
    }

    @Override
    public void setBoolean(String key, boolean value) {
        Editor editor = mSharedPref.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    @Override
    public void setBoolean(Map<String, Boolean> map) {
        if (map == null || map.isEmpty()) {
            return;
        }

        Editor editor = mSharedPref.edit();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            editor.putBoolean(key, map.get(key));
        }
        editor.commit();
    }

    @Override
    public void setInteger(String key, int value) {
        Editor editor = mSharedPref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    @Override
    public void setInteger(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return;
        }

        Editor editor = mSharedPref.edit();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            editor.putInt(key, map.get(key));
        }
        editor.commit();
    }

    @Override
    public void setFloat(String key, float value) {
        Editor editor = mSharedPref.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    @Override
    public void setFloat(Map<String, Float> map) {
        if (map == null || map.isEmpty()) {
            return;
        }

        Editor editor = mSharedPref.edit();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            editor.putFloat(key, map.get(key));
        }
        editor.commit();
    }

    @Override
    public void setLong(String key, long value) {
        Editor editor = mSharedPref.edit();
        editor.putLong(key, value);
        editor.commit();
    }


    @Override
    public void setLong(Map<String, Long> map) {
        if (map == null || map.isEmpty()) {
            return;
        }

        Editor editor = mSharedPref.edit();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            editor.putLong(key, map.get(key));
        }
        editor.commit();
    }

    @Override
    public void setString(String key, String value) {
        if (null != value) {
            //要过滤'\0',否则会使XML读取异常
            value = value.replace("\0", "");
        }

        Editor editor = mSharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    @Override
    public void setString(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }

        Editor editor = mSharedPref.edit();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String value = map.get(key);
            if (null != value) {
                //要过滤'\0',否则会使XML读取异常
                value = value.replace("\0", "");
            }
            editor.putString(key, value);
        }
        editor.commit();
    }

    @Override
    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return mSharedPref.getBoolean(key, defaultValue);
    }

    @Override
    public int getInt(String key) {
        return getInt(key, 0);
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return mSharedPref.getInt(key, defaultValue);
    }

    @Override
    public float getFloat(String key) {
        return getFloat(key, 0);
    }

    @Override
    public float getFloat(String key, float defaultValue) {
        return mSharedPref.getFloat(key, defaultValue);
    }

    @Override
    public long getLong(String key) {
        return getLong(key, 0);
    }

    @Override
    public long getLong(String key, long defaultValue) {
        return mSharedPref.getLong(key, defaultValue);
    }

    @Override
    public String getString(String key) {
        return getString(key, null);
    }

    @Override
    public String getString(String key, String defaultValue) {
        return mSharedPref.getString(key, defaultValue);
    }

    @Override
    public void writeObject(String filePath, Object object) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        try {
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } finally {
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        }
    }

    @Override
    public <T> T readObject(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            return (T) objectInputStream.readObject();
        } finally {
            if (objectInputStream != null) {
                objectInputStream.close();
            }
        }
    }

    @Override
    public void deleteObject(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override
    public void remove(String key) {
        //如果key不为空，把key删掉
        if (!TextUtils.isEmpty(key)) {
            Editor editor = mSharedPref.edit();
            editor.remove(key);
            editor.commit();
        }
    }
}
