package com.fpliu.newton.setting;

import android.content.Context;

/**
 * ISettings的工厂类，避免外部直接依赖他的实现类
 *
 * @author 792793182@qq.com.com 2014-9-29
 */
public final class SettingFactory {

    private SettingFactory() {
    }

    public static ISetting newInstance(Context context, String name) {
        return new SettingImpl(context, name);
    }

    private static ISetting setting;

    public static ISetting getInstance(Context context) {
        if (setting == null) {
            synchronized (SettingFactory.class) {
                if (setting == null) {
                    setting = new SettingImpl(context, "setting");
                }
            }
        }
        return setting;
    }
}
