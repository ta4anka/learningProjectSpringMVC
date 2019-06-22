package tk.ta4anka.springmvc.service;

import tk.ta4anka.springmvc.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    void save(Customer theCustomer);

    Customer getById(int theId);

    void deleteById(int theId);
}
