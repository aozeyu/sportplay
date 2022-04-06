package com.deyunjiaoyu.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.deyunjiaoyu.sportplay.bean.QueryInfo;
import com.deyunjiaoyu.sportplay.bean.User;
import com.deyunjiaoyu.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/alluser")
    public String getUserList(QueryInfo QueryInfo) {
        int numbers = userDao.getUserCounts("%" + QueryInfo.getQuery() + "%");
        int pageStart = (QueryInfo.getPageNum() - 1) * QueryInfo.getPageSize();
        List<User> allUsers = userDao.getAllUser("%" + QueryInfo.getQuery() + "%", pageStart, QueryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<String, Object>();
        res.put("numbers",numbers);
        res.put("data",allUsers);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
}
