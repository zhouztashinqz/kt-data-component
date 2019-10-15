package com.snowofsunflower.android.data.db.core;

import android.content.Context;

/**
 * Created by zhouztashin on 2018/11/5.
 * 数据库
 */

interface IOrmDb {
    /**
     * 数据库初始化
     */
    fun init(c: Context, config: IDBConfig)
}
