package com.feicui.demoormlite.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.feicui.demoormlite.model.RepoGroup;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by MLXPHONE on 2016/12/14 0014.
 */

public class DBHelp extends OrmLiteSqliteOpenHelper {
    private static DBHelp dbHelp;
    private Context context;
    public static synchronized DBHelp getInstance(Context context){
        if (dbHelp==null){
            dbHelp=new DBHelp(context.getApplicationContext());
        }
        return dbHelp;
    }

    public DBHelp(Context context) {
        super(context, "testdb", null, 3);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        //创建表
        try {
            TableUtils.createTableIfNotExists(connectionSource, RepoGroup.class);
            new RepoGroupDao(this).createOrUpdate( RepoGroup.getDefaultGroup(context) );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        //删除数据
        try {
            TableUtils.dropTable(connectionSource,RepoGroup.class,true);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
