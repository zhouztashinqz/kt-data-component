package com.snowofsunflower.android.data.db.core

/**
 * 数据库配置默认类
 */
class DBConfig(override val dbName: String, override val version: Int, override val encryptKey: String = "") : IDBConfig
