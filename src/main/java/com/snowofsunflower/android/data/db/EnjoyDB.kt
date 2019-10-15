package com.snowofsunflower.android.data.db;

import com.snowofsunflower.android.data.db.core.IOrmDAO
import com.snowofsunflower.android.data.db.core.IOrmDb
import com.snowofsunflower.android.data.db.greendaoimpl.GreenDaoDBImpl
import com.snowofsunflower.android.data.db.greendaoimpl.GreenDaoImpl

/**
 * Created by zhouztashin on 2018/11/5.
 * 数据库对外类
 */

class EnjoyDB {
    companion object {
        /**
         * 获取数据库操作对象
         */
        val db: IOrmDb = GreenDaoDBImpl
        val dao: IOrmDAO?
            get() {
                return GreenDaoImpl.getInstance(GreenDaoDBImpl)
            }
    }


}
