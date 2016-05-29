package vpb.Specefication;

import vpb.Entity.Payment;

public class MoneyNoMoreSpecification extends AbstractSpecification{
    private long moneyNoMoreValue;

    public MoneyNoMoreSpecification(long moneyNoMoreValue) {
        this.moneyNoMoreValue = moneyNoMoreValue;
    }

    public boolean isSatisfiedBy(Payment payment) {
        return moneyNoMoreValue > payment.getPayment();
    }
}
