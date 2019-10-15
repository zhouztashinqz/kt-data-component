package com.snowofsunflower.android.data.db.greendaoimpl

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.snowofsunflower.android.data.db.core.IDBConfig
import com.snowofsunflower.android.data.db.core.IOrmDb
import org.greenrobot.greendao.database.Database
import org.greenrobot.greendao.query.QueryBuilder

/**
 * GreenDao实现类
 */
//TODO Fix 提示内存泄露
@SuppressLint("StaticFieldLeak")
object GreenDaoDBImpl : IOrmDb {
    //内部对象,无法通过mDaoMaster在get里面做mDaoMaster的直接操作，会产生死循环
    private var _mDapMaster: DaoMaster? = null
    var mDaoMaster: DaoMaster? = null
        get() {
            if (_mDapMaster == null) {
                //TODO Fix Context、DBConfig都有可能为空,如何处理更好
                val helper = OpenHelper(mContext, mDbConfig?.dbName, null)
                _mDapMaster = DaoMaster(helper.getEncryptedReadableDb(mDbConfig?.encryptKey))
            }
            return _mDapMaster
        }
    private var _mDaoSession: DaoSession? = null
    var mDaoSession: DaoSession? = null
        get() {
            return _mDaoSession ?: mDaoMaster?.newSession()
        }
    private var mContext: Context? = null
    private var mDbConfig: IDBConfig? = null
    /**
     * 此方法需要在Application里面被调用
     */
    override fun init(c: Context, config: IDBConfig) {
        mContext = c.applicationContext
        mDbConfig = config
    }

    /**
     * 调试模式
     */
    fun setDebug() {
        QueryBuilder.LOG_SQL = true
        QueryBuilder.LOG_VALUES = true
    }

    /**
     * 关闭连接
     */
    private fun closeDaoession() {
        mDaoSession?.let {
            it.clear()
            mDaoSession = null
        }
    }

    /**
     * 关闭连接
     */
    fun closeConnection() = closeDaoession()

}

/**
 * Sqlite数据库更新
 */
class OpenHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?)
    : DaoMaster.OpenHelper(context, name, factory) {
    override fun onUpgrade(db: Database?, oldVersion: Int, newVersion: Int) {
        //TODO 添加数据库版本升级表处理
        onCreate(db)
    }

}