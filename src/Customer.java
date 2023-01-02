import java.util.Scanner;

public class Customer {
    private String customerName;
    private int customerId;


    public void setCustomerName(String s) {
        this.customerName=s;
    }

    public String getCustomerName() {
        return customerName;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                '}';
    }

}
