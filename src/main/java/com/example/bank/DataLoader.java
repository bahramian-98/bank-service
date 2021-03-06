package com.example.bank;

import com.example.bank.model.user.User;
import com.example.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {

        User user = new User();
        user.setUserName("bahramian");
        user.setPassword("123");
        user.setFullName("فاطمه بهرامیان");

        userRepository.save(user);

    }
}
