package com.example.demo.web;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下

public class UserController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value="/", method= RequestMethod.GET)
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public User postUser(@ModelAttribute User user) {
        return userRepository.save(user);

    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息 
        // url中的id可通过@PathVariable绑定到函数的参数中 
        return userRepository.findOne(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息 
        /*User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);*/
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User 
        userRepository.delete(id);

    }

}