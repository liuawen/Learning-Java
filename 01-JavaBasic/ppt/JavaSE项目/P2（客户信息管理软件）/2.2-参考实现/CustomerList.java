public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) return false;
        
        customers[total++] = customer;
        return true;
    }
     
    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index >= total) return false;
        
        customers[index] = cust;
        return true;
    }

    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) return false;
        
        for (int i = index + 1; i < total; i++) {
            customers[index] = customers[i];
        }
        
        customers[--total] = null;

        return true;
    }

    public Customer[] getAllCustomers() {
        Customer[] cust = new Customer[total];
        for (int i = 0; i < total; i++) {
            cust[i] = customers[i];
        }
        return cust;
    }

    public int getTotal() {
        return total;
    }

    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) return null;
        
        return customers[index];
    }
}
