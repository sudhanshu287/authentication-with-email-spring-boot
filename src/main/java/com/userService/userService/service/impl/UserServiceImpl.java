package com.userService.userService.service.impl;

import com.userService.userService.model.Confirmation;
import com.userService.userService.model.User;
import com.userService.userService.repository.ConfirmationRepository;
import com.userService.userService.repository.UserRepository;
import com.userService.userService.service.EmailService;
import com.userService.userService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ConfirmationRepository confirmationRepository;
    private final EmailService emailService;
    @Override
    public User saveUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already exist");
        }
        user.setEnabled(false);
        userRepository.save(user);
        Confirmation confirmation=new Confirmation(user);
        confirmationRepository.save(confirmation);
//        Todo send email to user with token
        emailService.sendSimpleEmailMessage(user.getName(), user.getEmail(),confirmation.getToken());
        return user;
    }

    @Override
    public Boolean verifyToken(String token) {
        Confirmation confirmation=confirmationRepository.findByToken(token);
        User user=userRepository.findByEmailIgnoreCase(confirmation.getUser().getEmail());
        user.setEnabled(true);
        userRepository.save(user);
        //confirmationRepository.delete(confirmation);
        return Boolean.TRUE;
    }
}
