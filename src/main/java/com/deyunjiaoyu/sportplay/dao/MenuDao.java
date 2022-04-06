package com.deyunjiaoyu.sportplay.dao;

import com.deyunjiaoyu.sportplay.bean.MainMenu;
import com.deyunjiaoyu.sportplay.bean.SubMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMenus();
}
