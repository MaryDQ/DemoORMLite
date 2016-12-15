package com.feicui.demoormlite.model;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by MLXPHONE on 2016/12/14 0014.
 */
@DatabaseTable(tableName = "repostiory_group")
public class RepoGroup {

    @DatabaseField(id = true)
    private int id;
    @DatabaseField(columnName = "NAME")
    private String name;

    @Override
    public String toString() {
        return "RepoGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static List<RepoGroup> repoGroupList;

    public static List<RepoGroup> getDefaultGroup(Context context){
        if (repoGroupList != null) {
            return repoGroupList;
        }
        try {
            // 读取文件
            InputStream inputStream = context.getAssets().open("repogroup.json");
            // 使用IOUTILS包
            String content = IOUtils.toString(inputStream);
            Gson gson = new Gson();
            repoGroupList = gson.fromJson(content.toString(),new TypeToken<List<RepoGroup>>(){}.getType());
            return repoGroupList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
