package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
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
    private  int version;
    private  int deleted;

}
