

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier decoratedNotifier;

    public NotifierDecorator(Notifier decoratedNotifier) {
        this.decoratedNotifier = decoratedNotifier;
    }

    @Override
    public void send(String message) {
        decoratedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier decoratedNotifier) {
        super(decoratedNotifier);
    }

    @Override
    public void send(String message) {
        decoratedNotifier.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier decoratedNotifier) {
        super(decoratedNotifier);
    }

    @Override
    public void send(String message) {
        decoratedNotifier.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsAndEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier allNotifiers = new SlackNotifierDecorator(smsAndEmailNotifier);

        allNotifiers.send("Hello, World!");
    }
}
