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

/*
key concepts of dependency injection (DI):

What is Dependency Injection?


It's a technique where one object supplies the dependencies of another object
Instead of having a class create its dependencies, they are "injected" from outside


Main Benefits:


Loose coupling between classes
Easier unit testing (can mock dependencies)
More flexible and maintainable code
Simpler configuration changes


Types of Dependency Injection:


Constructor Injection (shown in the example)
Setter Injection
Field Injection (using annotations like @Autowired)


In the example above:


EmailService is the dependency interface
GMMailServiceImpl and OutlookMailServiceImpl are concrete implementations
UserNotificationService depends on EmailService but doesn't create it
The dependency is injected through the constructor


Spring Framework Support:


Spring can automatically handle dependency injection
Uses annotations like @Autowired, @Component, @Service
Configuration can be done via Java config (@Configuration) or XML

Would you like me to explain any specific aspect in more detail? For example, we could explore:

Different types of dependency injection
How to use Spring's dependency injection
Best practices for dependency injection
Testing with dependency injection */