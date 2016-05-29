package vpb.Specefication;

import vpb.Entity.Payment;

import java.util.Date;

public class TimeBetweenSpecification extends AbstractSpecification {
    private Date start;
    private Date end;

    public TimeBetweenSpecification(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public boolean isSatisfiedBy(Payment payment) {
        return start.getTime() >= payment.getTime().getTime() && payment.getTime().getTime() <= end.getTime();
    }
}
