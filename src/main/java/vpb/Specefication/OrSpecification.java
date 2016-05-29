package vpb.Specefication;

import vpb.Entity.Payment;

public class OrSpecification extends AbstractSpecification{
    private Specification specification1;
    private Specification specification2;

    public OrSpecification(Specification specification1, Specification specification2) {
        this.specification1 = specification1;
        this.specification2 = specification2;
    }

    public boolean isSatisfiedBy(Payment payment) {
        return specification1.isSatisfiedBy(payment) || specification2.isSatisfiedBy(payment);
    }
}
