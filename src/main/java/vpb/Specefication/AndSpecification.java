package vpb.Specefication;

import vpb.Entity.Payment;

public class AndSpecification extends AbstractSpecification {
    private Specification specification1;
    private Specification specification2;

    public AndSpecification(final Specification specification1, final Specification specification2) {
        this.specification1 = specification1;
        this.specification2 = specification2;
    }

    public boolean isSatisfiedBy(final Payment payment) {
        return specification1.isSatisfiedBy(payment) && specification2.isSatisfiedBy(payment);
    }
}
