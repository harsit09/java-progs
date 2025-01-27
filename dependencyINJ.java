// Interface for email service
interface EmailService {
    void sendEmail(String message);
}

// Implementation of email service
class GMMailServiceImpl implements EmailService {
    @Override
    public void sendEmail(String message) {
        System.out.println("Sending email via Gmail: " + message);
    }
}

// Alternative implementation
class OutlookMailServiceImpl implements EmailService {
    @Override
    public void sendEmail(String message) {
        System.out.println("Sending email via Outlook: " + message);
    }
}

// User notification service that depends on EmailService
class UserNotificationService {
    private final EmailService emailService;  // Dependency

    // Constructor Injection
    public UserNotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void notifyUser(String username) {
        String message = "Hello " + username + ", this is a notification.";
        emailService.sendEmail(message);
    }
}

// Example using Spring Framework
@Configuration
class AppConfig {
    @Bean
    public EmailService emailService() {
        return new GMMailServiceImpl();  // We can easily switch to OutlookMailServiceImpl
    }

    @Bean
    public UserNotificationService userNotificationService(EmailService emailService) {
        return new UserNotificationService(emailService);
    }
}

// Usage example
class Main {
    public static void main(String[] args) {
        // Manual dependency injection
        EmailService emailService = new GMMailServiceImpl();
        UserNotificationService notificationService = new UserNotificationService(emailService);
        notificationService.notifyUser("John");

        // With Spring Framework, it would be automatically injected:
        // @Autowired
        // UserNotificationService notificationService;
    }
}