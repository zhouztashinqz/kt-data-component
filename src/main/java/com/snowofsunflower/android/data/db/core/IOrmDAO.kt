package com.snowofsunflower.android.data.db.core;

/**
 * Created by zhouztashin on 2018/11/5.
 * ORM数据库操作
 */

interface IOrmDAO {

    /**
     * 插入数据
     */
    fun <T> insert(item: T): Boolean

    /**
     * 插入列表,全部操作成功才算插入成功
     */
    fun <T> insertList(list: List<T>): Boolean

    /**
     * 更新数据
     */
    fun <T> update(item: T)

    /**
     * 根据条件更新数据
     */
    fun <T> update(item: T, key: ORMKey)

    /**
     * 删除数据
     */
    fun <T> delete(item: T)

    /**
     * 根据条件删除数据
     */
    fun <T> delete(item: T, key: ORMKey)

    /**
     * 根据类型删除所有数据
     */
    fun deleteAll(cls: Class<*>)

    /**
     * 获取列表
     */
    fun <T> getAll(cls: Class<T>): List<T>

    /**
     * 根据条件获取数据
     */
    fun <T> getOne(cls: Class<*>, key: ORMKey): T?
}
