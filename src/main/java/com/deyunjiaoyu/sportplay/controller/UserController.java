package com.deyunjiaoyu.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.deyunjiaoyu.sportplay.bean.QueryInfo;
import com.deyunjiaoyu.sportplay.bean.User;
import com.deyunjiaoyu.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        res.put("numbers", numbers);
        res.put("data", allUsers);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/userstate")
    public String updateUserState(@RequestParam("id") Integer id, @RequestParam("state") Boolean state) {
        int i = userDao.updateState(id, state);
        return i > 0 ? "success" : "error";
    }
    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user) {
        user.setRole("普通用户");
        user.setState(false);
        int i = userDao.addUser(user);
        return i > 0 ? "success" : "error";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Integer id) {
        int i = userDao.deleteUser(id);
        return i > 0 ? "success" : "error";
    }
    @RequestMapping("/modifyUser")
    public String modifyUser(@RequestBody User user) {
        int i = userDao.modifyUser(user);
        return i > 0 ? "success" : "error";
    }
}
