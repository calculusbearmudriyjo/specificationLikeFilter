package vpb.Specefication;

import vpb.Entity.Payment;

public class NotSpecification extends AbstractSpecification {
    private Specification specification1;

    public NotSpecification(Specification specification1) {
        this.specification1 = specification1;
    }

    public boolean isSatisfiedBy(Payment payment) {
        return !specification1.isSatisfiedBy(payment);
    }
}
