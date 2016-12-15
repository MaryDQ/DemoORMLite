package com.feicui.demoormlite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.feicui.demoormlite.dao.DBHelp;
import com.feicui.demoormlite.dao.RepoGroupDao;
import com.feicui.demoormlite.model.RepoGroup;

import java.util.List;

/**
 * Created by MLXPHONE on 2016/12/15 0015.
 */

public class FravoriteFragment extends Fragment implements View.OnClickListener,PopupMenu.OnMenuItemClickListener {
    private ImageButton btnFilter;
    private RepoGroupDao mRepoGroupDao;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepoGroupDao = new RepoGroupDao(DBHelp.getInstance(getContext()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fravorite, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnFilter = (ImageButton) view.findViewById(R.id.btnFilter);
        btnFilter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        showPopupMenu(v);
    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(getContext(), view);
        Menu menu = popupMenu.getMenu();
        List<RepoGroup> repoGroups = mRepoGroupDao.queryForAll();
        for(RepoGroup repo:repoGroups){
            menu.add(Menu.NONE, repo.getId() ,Menu.NONE, repo.getName());
        }
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(getContext(), "click : " + item.getItemId(), Toast.LENGTH_SHORT).show();
        return true;
    }
}
