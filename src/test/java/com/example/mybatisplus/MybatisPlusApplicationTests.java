package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.userMapper;
import com.example.mybatisplus.entity.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.channels.NonWritableChannelException;
import java.util.*;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    userMapper userMapper;
   /* DataSource dataSource;*/

    @Test
    void contextLoads() {
      /* System.out.println("数据源:"+dataSource.getClass() );*/
        /*List<user> users = userMapper.selectList(null);
        users.forEach(System.out::println);*/
        user user = new user();
/*
        List list1 = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        list1.forEach(System.out::println);*/

        //添加操作
        user.setAge(20);
        user.setEmail("121@.com");
        user.setName("bilibili");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
      /*  user user = new user();
        user.setId(10);
        user.setName("GO语言");
        user.setEmail("1114@com");

        /*int insert = userMapper.insert(user);
        System.out.println(insert);*//*
        userMapper.updateById(user);*/

    }
    @Test
    public  void test1(){
        user user = userMapper.selectById(1);
        user.setName("versionTest");
        user.setEmail("11114@qq.com");
        userMapper.updateById(user);
    }
    //乐观锁多线程下失败模拟
    @Test
    public  void test2(){
        user user = userMapper.selectById(1);
        user.setName("bilibili");
        user.setEmail("shangan@qq.com");
        userMapper.updateById(user);

        user user1 = userMapper.selectById(1);
        user.setName("shangan");
        user.setEmail("gwy@qq.com");
        userMapper.updateById(user1);

        userMapper.updateById(user);
    }
    //指定id查询
    @Test
    public  void  test3(){
        user user = userMapper.selectById(1);
        System.out.println(user);
    }

    //批量查询
    @Test
    public  void test4(){
        List<user> users = userMapper.selectBatchIds(Arrays.asList(4, 5, 6, 7));
        users.forEach(System.out::println);
    }

    //条件查询之一 使用map操作
    @Test
    public void getMap1() {
       HashMap<String,Object>map1 = new HashMap<>();
        map1.put("name", "JAVA");
        map1.put("age", 18);
        List<user> users = userMapper.selectByMap(map1);
        users.forEach(System.out::println);
    }
    //分页查询
    @Test
    public  void  test5(){
        Page<user> page = new Page<>(1,5);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    //逻辑删除操作
    @Test
    public  void test6(){
        userMapper.deleteById(4);
    }

    //条件构造器
    @Test
    public void test7(){
        //查询name，eamil不为0且age大于等于12
        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("name");
        queryWrapper.isNotNull("email");
        queryWrapper.ge("age", 12);
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }
    //条件查询
    @Test
    public void test8(){
        //查询名字为JAVA
        QueryWrapper<user>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "JAVA");
        List<user> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
    //查询年龄在0-30岁之间的user
    @Test
    public void  test9(){
        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("age", 0, 30);
        List<user> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
        System.out.println("总数有："+userMapper.selectCount(queryWrapper));
    }
    //排序
    @Test
    public void test10(){
        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        QueryWrapper<user> queryWrapper1 = queryWrapper.orderByAsc("age");
        userMapper.selectList(queryWrapper1).forEach(System.out::println);
    }
    //子查询
    @Test
    public void  test11(){
        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id", "select id from user where id<10");
        List<Object> list = userMapper.selectObjs(queryWrapper);
        list.forEach(System.out::println);
    }
    //测试添加
    @Test
    public  void test12(){
        user user = new user();
        user.setEmail("1112@qq.com");
        user.setName("小芳");
        user.setAge(24);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    //测试修改
    @Test
    public  void  test13(){
        user user = new user();
        user.setAge(30);
        user.setId(16);
        user.setVersion(2);
        userMapper.updateById(user);
    }

    //乐观锁重新测试
    @Test
    public  void  test14(){
        user user = new user();
        user.setId(16);
        user.setAge(35);
        userMapper.updateById(user);

        user user1 = new user();
        user.setId(16);
        user.setAge(45);
        userMapper.updateById(user1);
        userMapper.updateById(user);
    }
    //测试逻辑删除
    @Test
    public  void test15(){
        userMapper.deleteById(16);
        List<com.example.mybatisplus.entity.user> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
