package vpb.Service;

import vpb.Entity.Customer;
import vpb.Entity.Payment;

import java.util.*;

public class PaymentServiceImplementation implements PaymentService{
    private HashMap<Integer, Payment> paymentsRepo = new HashMap<Integer, Payment>();

    public List<Payment> getPaymentsByCustomer(Customer customer) {
        List<Payment> result = new ArrayList<Payment>();
        for(Map.Entry<Integer,Payment> entry : paymentsRepo.entrySet()) {
            if(entry.getValue().getCustomer().equals(customer)) {
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public List<Payment> getPaymentsBetweenDate(Date start, Date end, Customer customer) {
        List<Payment> result = new ArrayList<Payment>();
        for(Map.Entry<Integer,Payment> entry : paymentsRepo.entrySet()) {
            Date paymentDate = entry.getValue().getTime();
            if(paymentDate.getTime() >= start.getTime() && paymentDate.getTime() <= end.getTime() && entry.getValue().getCustomer().equals(customer)) {
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public void addPayment(Payment payment) {
        paymentsRepo.put(payment.getId(), payment);
    }
}
