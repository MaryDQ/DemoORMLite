package com.feicui.demoormlite.dao;

import com.feicui.demoormlite.model.RepoGroup;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by MLXPHONE on 2016/12/14 0014.
 */

public class RepoGroupDao {
    private Dao<RepoGroup, Long> dao;


    public RepoGroupDao(DBHelp dbHelp) {
        try {
            dao=dbHelp.getDao(RepoGroup.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createOrUpdate(List<RepoGroup> list) {
        for (RepoGroup repo : list) {
            createOrUpdate(repo);
        }
    }

    //更新数据
    public void createOrUpdate(RepoGroup repoGroup) {
        try {
            dao.createOrUpdate(repoGroup);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //返回所有的数据
    public List<RepoGroup> queryForAll(){
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //根据ID查询
    public RepoGroup queryForId(long id){
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
