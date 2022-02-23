package com.example.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author junhao
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/239:26
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler{
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("version", 1, metaObject);
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
