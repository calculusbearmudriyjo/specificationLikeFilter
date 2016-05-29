package vpb.Entity;

import java.util.Date;

public interface Payment {
    public int getId();
    public long getPayment();
    public Date getTime();
    public String getPaymentPurpose();
    public Customer getCustomer();
}
