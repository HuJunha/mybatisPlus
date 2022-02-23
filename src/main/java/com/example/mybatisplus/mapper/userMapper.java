package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.entity.user;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author junhao
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/1715:29
 */

@Repository
@Mapper
public interface userMapper extends BaseMapper<user> {

}
