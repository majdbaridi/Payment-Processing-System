package com.majd.finance.service.impl;


import com.majd.finance.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void notifyUser(com.majd.finance.entity.User user, String message) {
        String notification = "Dear " + user.getName() + ", " + message;
        rabbitTemplate.convertAndSend("notificationQueue", notification);

    }
}