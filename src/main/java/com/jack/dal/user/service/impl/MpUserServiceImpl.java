package com.jack.dal.user.service.impl;

import com.jack.dal.user.entity.User;
import com.jack.dal.user.mapper.UserMapper;
import com.jack.dal.user.service.MpUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jack
 * @since 2017-12-22
 */
public class MpUserServiceImpl extends ServiceImpl<UserMapper, User> implements MpUserService {

}
