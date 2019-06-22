package tk.ta4anka.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.ta4anka.springmvc.dao.CustomerDAO;
import tk.ta4anka.springmvc.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    // need to inject customer DAO
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void save(Customer theCustomer) {
        customerDAO.save(theCustomer);

    }

    @Override
    @Transactional
    public Customer getById(int theId) {
        return customerDAO.getById(theId);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        customerDAO.deleteById(theId);

    }
}
