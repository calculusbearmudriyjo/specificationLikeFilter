package vpb.Specefication;

import vpb.Entity.Payment;
import vpb.Service.PaymentService;

import java.util.Date;
import java.util.List;

public class TimeBerweenOnlyOnePerposeSpecification extends AbstractSpecification{
    private Date start;
    private Date end;
    private String purpose;
    private PaymentService paymentService;

    public TimeBerweenOnlyOnePerposeSpecification(Date start, Date end, String purpose, PaymentService paymentService) {
        this.start = start;
        this.end = end;
        this.purpose = purpose;
        this.paymentService = paymentService;
    }

    public boolean isSatisfiedBy(Payment incPayment) {
        List<Payment> payments = paymentService.getPaymentsBetweenDate(start, end, incPayment.getCustomer());
        for(Payment payment : payments) {
            System.out.print(payment);
            if(incPayment.getPaymentPurpose().equals(payment.getPaymentPurpose())) {
                return false;
            }
        }
        return true;
    }
}
