@FunctionalInterface
interface Notifier {
    void send(String message);
}

interface Urgent {}

class EmailSender implements Urgent {
    void sendEmail(String message) {
        System.out.println("Email: " + message);
    }
}

class SmsSender implements Urgent {
    void sendSms(String message) {
        System.out.println("SMS: " + message);
    }
}

public class NotifierDemo {
    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();
        SmsSender smsSender = new SmsSender();
        Notifier email = message -> emailSender.sendEmail(message);
        Notifier sms = message -> smsSender.sendSms(message);
        Notifier[] notifiers = {email, sms};
        String message = "Meeting at 5 PM";

        for (Notifier notifier : notifiers) notifier.send(message);
        if (emailSender instanceof Urgent) email.send("URGENT: " + message);
        if (smsSender instanceof Urgent) sms.send("URGENT: " + message);
    }
}
