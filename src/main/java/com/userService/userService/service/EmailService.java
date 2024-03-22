package com.userService.userService.service;

import org.springframework.scheduling.annotation.Async;

public interface EmailService {
    @Async
    void sendSimpleEmailMessage(String name,String to,String  token);
    @Async
    void sendMimeMessageWithAttachment(String name,String to,String  token);
    @Async
    void sendMimeMessageWithEmbeddedImages(String name,String to,String  token);
    @Async
    void sendMimeMessageWithEmbeddedFiles(String name,String to,String  token);
    @Async
    void sendHtmlEmail(String name,String to,String  token);
    @Async
    void sendHtmlEmailWithEmbeddedFiles(String name,String to,String  token);
}
