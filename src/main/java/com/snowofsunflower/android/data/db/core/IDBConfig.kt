package com.snowofsunflower.android.data.db.core;

/**
 * Created by zhouztashin on 2018/11/5.
 * 数据库配置
 */

interface IDBConfig {

    /**
     * 数据库名称
     */
    val dbName: String

    /**
     * 数据库版本
     */
    val version: Int

    /**
     * 加密密钥
     */
    val encryptKey: String

}
