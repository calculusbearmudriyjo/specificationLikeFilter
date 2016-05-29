package vpb.Specefication;

import vpb.Entity.Payment;

public interface Specification {
    boolean isSatisfiedBy(Payment payment);

    Specification and(Specification specification);

    Specification or(Specification specification);

    Specification not(Specification specification);
}
