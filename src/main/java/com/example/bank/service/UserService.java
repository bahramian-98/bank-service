package com.example.bank.service;

import com.example.bank.mapper.UserMapper;
import com.example.bank.repository.UserRepository;
import com.example.bank.service.core.BaseService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper,
                       UserRepository userRepository) {
        super(userMapper, userRepository);
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }
}
