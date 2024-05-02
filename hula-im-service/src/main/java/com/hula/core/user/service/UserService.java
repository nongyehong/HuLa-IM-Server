package com.hula.core.user.service;

import com.hula.core.user.domain.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author nyh
 * @since 2024-04-06
 */
public interface UserService {

    Long register(User insert);
}