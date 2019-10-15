package com.snowofsunflower.android.data.db.greendaoimpl;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhouztashin on 2018/11/5.
 * 用于GreenDao生成Dao操作类，避免编译不通过。
 */

@Entity
public class DefaultModel {

    private String id;


    @Generated(hash = 1788776010)
    public DefaultModel(String id) {
        this.id = id;
    }

    @Generated(hash = 23216497)
    public DefaultModel() {
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
