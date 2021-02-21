package com.srikanth.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.srikanth.model.User;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SqsSender {

  private QueueMessagingTemplate queueMessagingTemplate;

  public SqsSender(AmazonSQSAsync amazonSQSAsync) {
    this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSQSAsync);
  }

  public void send(User user) {
    System.out.println("Sending user to SQS..." + user.getName());
    queueMessagingTemplate.convertAndSend("user-cache-details", user);
  }
}
