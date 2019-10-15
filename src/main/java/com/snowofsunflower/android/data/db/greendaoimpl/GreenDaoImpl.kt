package com.snowofsunflower.android.data.db.greendaoimpl

import com.snowofsunflower.android.data.db.core.IOrmDAO
import com.snowofsunflower.android.data.db.core.ORMKey

class GreenDaoImpl(private val mGreenDaoHelper: GreenDaoDBImpl?) : IOrmDAO {
    override fun <T> insert(item: T): Boolean {
        return mGreenDaoHelper?.let {
            val result = it.mDaoSession?.insert(item)
            result?.let {
                result != -1L
            } ?: false
        } ?: false
    }

    override fun <T> insertList(list: List<T>): Boolean {
        var result = false
        mGreenDaoHelper?.run {
            var l: Long = -1L
            this.mDaoSession?.runInTx {
                val failCount = list.count {
                    this.mDaoSession?.insertOrReplace(it) == -1L
                }
                result = failCount == 0

            }
        }
        return false
    }

    override fun <T> update(item: T) {
        mGreenDaoHelper?.mDaoSession?.update(item)
    }

    override fun <T> update(item: T, key: ORMKey) {
        //TODO 添加条件处理 通过SQL语句
    }

    override fun <T> delete(item: T) {
        mGreenDaoHelper?.mDaoSession?.delete(item)
    }

    override fun <T> delete(item: T, key: ORMKey) {
    }

    override fun deleteAll(cls: Class<*>) {
        mGreenDaoHelper?.mDaoSession?.deleteAll(cls)
    }

    override fun <T> getAll(cls: Class<T>): List<T> {
        return mGreenDaoHelper?.let {
            //TODO Fix 泛型K如何处理
            it.mDaoSession?.loadAll<T, ORMKey>(cls)
        } ?: arrayListOf()
    }

    override fun <T> getOne(cls: Class<*>, key: ORMKey): T? {
        // mGreenDaoHelper?.mDaoSession?.load()
        return null
    }

    companion object {
        var mDAOImpl: GreenDaoImpl? = null
        @Synchronized
        fun getInstance(greenDaoHelper: GreenDaoDBImpl): GreenDaoImpl? {
            if (mDAOImpl == null) {
                mDAOImpl = GreenDaoImpl(greenDaoHelper)
            }
            return mDAOImpl
        }
    }

}