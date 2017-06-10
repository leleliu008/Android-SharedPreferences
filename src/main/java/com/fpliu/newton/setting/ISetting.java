package com.fpliu.newton.setting;

import java.io.IOException;
import java.util.Map;

/**
 * 设置
 *
 * @author 792793182@qq.com.com 2014-9-29
 */
public interface ISetting {

    /**
     * 该键是否被设置过值
     * @param key 键
     */
    boolean exist(String key);

    /**
     * 删除缓存中的key
     *
     * @param key 键
     */
    void remove(String key);

    /**
     * 保存boolean类型的值
     *
     * @param key   键
     * @param value 值
     */
    void setBoolean(String key, boolean value);

    /**
     * 保存多个boolean类型的值
     *
     * @param map
     */
    void setBoolean(Map<String, Boolean> map);

    /**
     * 保存int类型的值
     *
     * @param key   键
     * @param value 值
     */
    void setInteger(String key, int value);

    /**
     * 保存int类型的值
     *
     * @param map
     */
    void setInteger(Map<String, Integer> map);

    /**
     * 保存float类型的值
     *
     * @param key   键
     * @param value 值
     */
    void setFloat(String key, float value);

    /**
     * 保存float类型的值
     *
     * @param map
     */
    void setFloat(Map<String, Float> map);

    /**
     * 保存long类型的值
     *
     * @param key   键
     * @param value 值
     */
    void setLong(String key, long value);

    /**
     * 保存long类型的值
     *
     * @param map
     */
    void setLong(Map<String, Long> map);

    /**
     * 保存String类型的值
     *
     * @param key   键
     * @param value 值
     */
    void setString(String key, String value);

    /**
     * 保存String类型的值
     *
     * @param map
     */
    void setString(Map<String, String> map);

    /**
     * 获取boolean类型的值
     *
     * @param key 键
     */
    boolean getBoolean(String key);

    /**
     * 获取boolean类型的值，如果不存在就返回给定的默认值，并将默认值保存起来
     *
     * @param key 键
     */
    boolean getBoolean(String key, boolean defaultValue);

    /**
     * 获取int类型的值
     *
     * @param key 键
     */
    int getInt(String key);

    /**
     * 获取int类型的值，如果不存在就返回给定的默认值，并将默认值保存起来
     *
     * @param key 键
     */
    int getInt(String key, int defaultValue);

    /**
     * 获取float类型的值
     *
     * @param key 键
     */
    float getFloat(String key);

    /**
     * 获取float类型的值，如果不存在就返回给定的默认值，并将默认值保存起来
     *
     * @param key 键
     */
    float getFloat(String key, float defaultValue);

    /**
     * 获取long类型的值
     *
     * @param key 键
     */
    long getLong(String key);

    /**
     * 获取long类型的值，如果不存在就返回给定的默认值，并将默认值保存起来
     *
     * @param key 键
     */
    long getLong(String key, long defaultValue);

    /**
     * 获取String类型的值
     *
     * @param key 键
     */
    String getString(String key);

    /**
     * 获取String类型的值，如果不存在就返回给定的默认值，并将默认值保存起来
     *
     * @param key 键
     */
    String getString(String key, String defaultValue);

    /**
     * 序列化对象
     *
     * @param filePath 文件名(完整路径)
     * @param object   对象
     */
    void writeObject(String filePath, Object object) throws IOException;

    /**
     * 反序列化
     *
     * @param fileName 文件名
     */
    <T> T readObject(String fileName) throws IOException, ClassNotFoundException;

    /**
     * 清除序列化的数据
     */
    void deleteObject(String fileName);
}
