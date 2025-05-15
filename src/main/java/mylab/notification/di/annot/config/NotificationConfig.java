package mylab.notification.di.annot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;

@Configuration
public class NotificationConfig {
	@Bean
	public EmailNotificationService emailNotificationService() {
		EmailNotificationService service = new EmailNotificationService("smpt",1234);
		return service;
	}
	
	@Bean
	public SmsNotificationService smsNotificationService() {
		SmsNotificationService service = new SmsNotificationService("naver");
		return service;
	}
	
	@Bean
	public NotificationManager notificationManager() {
		NotificationManager manager = new NotificationManager(emailNotificationService(), smsNotificationService());
		return manager;
	}
}
