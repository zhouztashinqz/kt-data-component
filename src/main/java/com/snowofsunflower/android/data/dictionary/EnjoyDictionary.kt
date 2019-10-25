package com.snowofsunflower.android.data.dictionary

import android.content.Context
import android.content.SharedPreferences

/**
 * Android Shapreferences 封装类
 * TODO 支持多个Shaprefercenes文件的访问
 */
class EnjoyDictionary {
    var mDictName: String? = null
    var mApplicationContext: Context? = null

    companion object {
        private var instance: EnjoyDictionary? = null
        /**
         * 需要初始化调用该类
         */
        @Synchronized
        fun initDictionary(context: Context, dictName: String) {
            if (instance == null) {
                instance = EnjoyDictionary()
                instance?.let {
                    it.mDictName = dictName
                    it.mApplicationContext = context.applicationContext
                }
            }

        }

        private fun sharedPreferences(): SharedPreferences? {
            return instance?.let {
                it.mApplicationContext?.getSharedPreferences(it.mDictName, Context.MODE_PRIVATE)
            }
        }

        /**
         * 保存键值对
         */
        fun save(key: String, o: Any?): Boolean {
            return sharedPreferences()?.let {
                val result = o?.run {
                    val edit = it.edit()
                    when (o) {
                        is Int -> edit.putInt(key, o).commit()
                        is Long -> edit.putLong(key, o).commit()
                        is Boolean -> edit.putBoolean(key, o).commit()
                        is String -> edit.putString(key, o).commit()
                        else -> false
                    }
                    //Elvis运算符是否加大了阅读的难度？
                } ?: false
                result
            } ?: false
        }

        /**
         * 获取Int值
         */
        fun getInt(key: String, def: Int): Int = sharedPreferences()?.getInt(key, def) ?: def

        /**
         * 获取Boolean值
         */
        fun getBoolean(key: String, def: Boolean): Boolean = sharedPreferences()?.getBoolean(key, def)
                ?: false

        /**
         * 获取Long值
         */
        fun getLong(key: String, def: Long): Long = sharedPreferences()?.getLong(key, def) ?: def

        /**
         * 获取String
         */
        fun getString(key: String, def: String): String = sharedPreferences()?.getString(key, def)
                ?: def

    }


}
