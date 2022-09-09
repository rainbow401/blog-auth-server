package com.blog.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.auth.dto.LoginDTO;
import com.blog.common.entity.User;

public interface UserService extends IService<User> {

    boolean login(LoginDTO dto);

}
