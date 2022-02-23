package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.jar.Attributes;

/**
 * @author junhao
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/1715:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {
    private  int id;
    private  String name;
    private  int age;
    private  String email;
    @TableField(fill = FieldFill.INSERT)
    private   Date  createTime;
    @TableField(fill = FieldFill.UPDATE)
    private   Date  updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private  Integer version;
    @TableLogic
    private  int deleted;

}
