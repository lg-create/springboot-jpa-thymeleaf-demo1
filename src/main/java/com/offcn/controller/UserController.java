package com.offcn.controller;

import com.offcn.service.UserService;
import com.offcn.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService us;

    //获取列表数据，跳转到列表模板
    @RequestMapping("/")
    public String  getList(Model m){
        List<User> list = us.findAll();
        m.addAttribute("list",list);
        return "list";
    }

    //添加按钮
    @RequestMapping("/toAdd")
    public String add(){
        return "add";
    }

    //保存新增用户
    @PostMapping("/add")
    public String add(User user){
        us.add(user);
        return "redirect:/";
    }

    //跳转到编辑页面

    @GetMapping("/toEdit/{id}")
    public String toEdit(@PathVariable Long id, Model m){
        User user = us.findOne(id);
        m.addAttribute("user",user);
        return "edit";
    }

    //保存修改数据
    @PostMapping("/update")
    public String update(User user){
        us.update(user);
        return "redirect:/";
    }
}
