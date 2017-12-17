package com.jack.dal.mapper.genmapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jack.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Copyright © 2017 上海金互行金融服务有限公司. All rights reserved. *
 *
 * @Title:
 * @Prject: mybatis-plus-test
 * @Package: com.jack.dal.mapper.genmapper
 * @Description: ${todo}
 * @author: jack liujialin@jinhuhang.com.cn
 * @date: 2017/12/17 15:00
 * @version: V1.0
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("selectUserList")
    List<User> selectUserList(Pagination pagination,String name);
}
