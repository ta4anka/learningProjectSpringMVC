package tk.ta4anka.springmvc.dao;

import tk.ta4anka.springmvc.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer>  getCustomers();

    void save(Customer theCustomer);

    Customer getById(int theId);

    void deleteById(int theId);
}
