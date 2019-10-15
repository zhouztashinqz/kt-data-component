package com.snowofsunflower.android.data.db.core;

/**
 * Created by zhouztashin on 2018/11/5.
 * 数据库处理条件
 * //TODO 支持多种条件
 */

interface ORMKey {

    fun key(): String

    fun value(): String

}
