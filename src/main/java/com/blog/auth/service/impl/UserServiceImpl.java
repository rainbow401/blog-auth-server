package com.blog.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.auth.dto.LoginDTO;
import com.blog.auth.mapper.UserMapper;
import com.blog.auth.service.UserService;
import com.blog.common.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean login(LoginDTO dto) {
        verifyPassword(dto);

        return true;
    }

    private void verifyPassword(LoginDTO dto) {
        // todo 密码验证
    }
}
