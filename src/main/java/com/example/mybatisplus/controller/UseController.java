package com.example.mybatisplus.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.entity.user;
import com.example.mybatisplus.mapper.userMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author junhao
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/1716:37
 */
@Slf4j
@RestController
public class UseController {
    @Autowired
    userMapper userMapper;
    @GetMapping("/select")
    public  List<user> select(){
        return  userMapper.selectList(null);
    }

    @RequestMapping("/fenye")
    public Object page(){
        Page<user> page = new Page<>(1,3);
       return userMapper.selectPage(page, null);
    }
}
