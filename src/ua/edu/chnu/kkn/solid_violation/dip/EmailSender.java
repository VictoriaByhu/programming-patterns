package ua.edu.chnu.kkn.solid_violation.dip;

public class EmailSender implements MessageSender{
    @Override
    public void send(Email email) {
        System.out.print("To:" + email.getTo() +
                ", Subject: " + email.getSubject() +
                ", Message: " + email.getMessage());
    }
}
