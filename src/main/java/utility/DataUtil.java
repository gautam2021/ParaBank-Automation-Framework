package utility;

import model.Customer;

public final class DataUtil {

    private DataUtil() {
    }

    private static final ThreadLocal<Customer> customer=new ThreadLocal<>();
    
    // set customer
    public static void setCustomer(Customer customerData) {
        customer.set(customerData);
    }

    // get customer
    public static Customer getCustomer() {
        return customer.get();
    }
    
    // release customer data
    public static void clearCustomer() {
	customer.remove();
    }
}