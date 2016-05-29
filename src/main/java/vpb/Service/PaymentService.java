package vpb.Service;

import vpb.Entity.Customer;
import vpb.Entity.Payment;

import java.util.Date;
import java.util.List;

public interface PaymentService {
    public List<Payment> getPaymentsByCustomer(Customer customer);
    public List<Payment> getPaymentsBetweenDate(Date start, Date end, Customer customer);
    public void addPayment(Payment payment);
}
