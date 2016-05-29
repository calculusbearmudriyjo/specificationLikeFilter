package vpb.Entity;

import java.util.Date;

public class PaymentImpl implements Payment{
    private int id;
    private Customer customer;
    private Date create;
    private String purpose;
    private long value;

    public PaymentImpl(int id, Customer customer, Date create, String purpose, long value) {
        this.id = id;
        this.customer = customer;
        this.create = create;
        this.purpose = purpose;
        this.value = value;
    }

    public long getPayment() {
        return value;
    }

    public Date getTime() {
        return create;
    }

    public String getPaymentPurpose() {
        return purpose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Customer getCustomer() {
        return customer;
    }
}
