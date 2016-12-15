package com.feicui.demoormlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DBHelp dbHelp=DBHelp.getInstance(this);
//        RepoGroupDao repoGroupDao=new RepoGroupDao(dbHelp);
//        for (int i=0;i<10;i++){
//            RepoGroup repoGroup=new RepoGroup();
//            repoGroup.setId(i+1);
//            repoGroup.setName("类别"+i);
//            repoGroupDao.createOrUpdate(repoGroup);
//        }
//        List<RepoGroup> repoGroupList=repoGroupDao.queryForAll();
//        for (RepoGroup group:repoGroupList){
//            Log.d(TAG, group.toString());
//        }
//
//        RepoGroup repoGroup=repoGroupDao.queryForId(5);
//        Log.d(TAG, repoGroup.toString());
        
    }

}
