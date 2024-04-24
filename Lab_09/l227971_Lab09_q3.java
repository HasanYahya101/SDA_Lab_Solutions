// Unified interface for sending and receiving messages
interface MessageService {
    void sendMessage(String message);
    String receiveMessage();
}

// SMS messaging service with its own specific interface
interface SMS {
    void sendSMS(String message);
    String receiveSMS();
}

// Email messaging service with its own specific interface
interface Email {
    void sendEmail(String message);
    String receiveEmail();
}

// Adapter for SMS messaging service
class SMSAdapter implements MessageService {
    private SMS smsService;

    public SMSAdapter(SMS smsService) {
        this.smsService = smsService;
    }

    @Override
    public void sendMessage(String message) {
        smsService.sendSMS(message);
    }

    @Override
    public String receiveMessage() {
        return smsService.receiveSMS();
    }
}

// Adapter for Email messaging service
class EmailAdapter implements MessageService {
    private Email emailService;

    public EmailAdapter(Email emailService) {
        this.emailService = emailService;
    }

    @Override
    public void sendMessage(String message) {
        emailService.sendEmail(message);
    }

    @Override
    public String receiveMessage() {
        return emailService.receiveEmail();
    }
}

// Messaging application using the unified interface
class MessagingApplication {
    private MessageService messageService;

    public MessagingApplication(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendMessage(String message) {
        messageService.sendMessage(message);
    }

    public String receiveMessage() {
        return messageService.receiveMessage();
    }
}

// SMS messaging service implementation
class SMSService implements SMS {
    @Override
    public void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }

    @Override
    public String receiveSMS() {
        return "SMS received";
    }
}

// Email messaging service implementation
class EmailService implements Email {
    @Override
    public void sendEmail(String message) {
        System.out.println("Sending Email: " + message);
    }

    @Override
    public String receiveEmail() {
        return "Email received";
    }
}

// Main class to test the messaging application
public class l227971_Lab09_q3 {
    public static void main(String[] args) {
        // Create instances of SMS and Email services
        SMS smsService = new SMSService();
        Email emailService = new EmailService();

        // Create adapters for SMS and Email services
        MessageService smsAdapter = new SMSAdapter(smsService);
        MessageService emailAdapter = new EmailAdapter(emailService);

        // Create messaging application instances with the adapters
        MessagingApplication smsApp = new MessagingApplication(smsAdapter);
        MessagingApplication emailApp = new MessagingApplication(emailAdapter);

        // Use the messaging application to send and receive messages
        smsApp.sendMessage("Yo, me hasan");
        System.out.println(smsApp.receiveMessage());

        emailApp.sendMessage("Yo, me not hasan");
        System.out.println(emailApp.receiveMessage());
    }
}
