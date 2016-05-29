package vpb;

import junit.framework.TestCase;
import vpb.Entity.Customer;
import vpb.Entity.CustomerImpl;
import vpb.Entity.Payment;
import vpb.Entity.PaymentImpl;
import vpb.Service.PaymentService;
import vpb.Service.PaymentServiceImplementation;
import vpb.Specefication.MoneyNoMoreSpecification;
import vpb.Specefication.Specification;
import vpb.Specefication.TimeBerweenOnlyOnePerposeSpecification;

import java.util.Date;

// TEST FILTER Не более 5000 руб. днем с 9:00 утра до 23:00 за одну услугу
// all object a simplify.
public class test extends TestCase {
    private static final long startTimestamp = 1467190800;// 9 00 29.2016
    private static final long createTimestamp = 1467190900;
    private static final long endTimestamp = 1467234000;// 21 00 21.2016
    private static final String purposePayment = "MTS";

    public void testFirstFilterTrue() {
        Date filterStartDate = new Date(startTimestamp);

        Date filterEndDate = new Date(endTimestamp);

        Date create = new Date(createTimestamp);

        Customer customer1 = new CustomerImpl(1, "Alex");
        Customer customer2 = new CustomerImpl(2, "Serj");
        Customer customer3 = new CustomerImpl(3, "Maria");

        Payment payment1 = new PaymentImpl(1,customer1, create, "exchange money", 1000);
        Payment payment2 = new PaymentImpl(2,customer2, create, purposePayment, 3000);
        Payment payment3 = new PaymentImpl(3,customer3, create, purposePayment, 500);
        Payment payment4 = new PaymentImpl(4,customer1, create, purposePayment, 500);

        PaymentService paymentService = new PaymentServiceImplementation();
        paymentService.addPayment(payment1);
        paymentService.addPayment(payment2);
        paymentService.addPayment(payment3);

        Specification moneySpec = new MoneyNoMoreSpecification(5000);
        Specification timeBetweenOnePurpose = new TimeBerweenOnlyOnePerposeSpecification(filterStartDate, filterEndDate, purposePayment, paymentService);
        Specification filter = moneySpec.and(timeBetweenOnePurpose);

        assertTrue(filter.isSatisfiedBy(payment4));
    }

    public void testFirstFilterFalse() {
        Date filterStartDate = new Date(startTimestamp);

        Date filterEndDate = new Date(endTimestamp);

        Date create = new Date(createTimestamp);

        Customer customer1 = new CustomerImpl(1, "Alex");
        Customer customer2 = new CustomerImpl(2, "Serj");
        Customer customer3 = new CustomerImpl(3, "Maria");

        Payment payment1 = new PaymentImpl(1,customer1, create, purposePayment, 1000);
        Payment payment2 = new PaymentImpl(2,customer2, create, purposePayment, 3000);
        Payment payment3 = new PaymentImpl(3,customer3, create, purposePayment, 500);
        Payment payment4 = new PaymentImpl(4,customer1, create, purposePayment, 500);

        PaymentService paymentService = new PaymentServiceImplementation();
        paymentService.addPayment(payment1);
        paymentService.addPayment(payment2);
        paymentService.addPayment(payment3);

        Specification moneySpec = new MoneyNoMoreSpecification(5000);
        Specification timeBetweenOnePurpose = new TimeBerweenOnlyOnePerposeSpecification(filterStartDate, filterEndDate, purposePayment, paymentService);
        Specification filter = moneySpec.and(timeBetweenOnePurpose);

        assertFalse(filter.isSatisfiedBy(payment4));

    }
}
