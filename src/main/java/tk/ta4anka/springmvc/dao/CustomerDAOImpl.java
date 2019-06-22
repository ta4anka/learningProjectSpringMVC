package tk.ta4anka.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.ta4anka.springmvc.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory

    @Autowired
    private SessionFactory sessionFactory; // this field will be autowired with bean id= "sessionFactory"
                                           // from 'spring-mvc-crud-demo-servlet.xml' file.


    @Override
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();


        // return the results
        return customers;
    }

    @Override
    public void save(Customer theCustomer) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/update theCustomer to db
        currentSession.saveOrUpdate(theCustomer);

        //saveOrUpdate() in Hibernate --> if(id) empty then INSERT new customer else UPDATE exiting customer

        }

    @Override
    public Customer getById(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // retrieve/read from database using the primary key
        Customer theCustomer = currentSession.get(Customer.class, theId);

        return theCustomer;
    }

    @Override
    public void deleteById(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete customer
        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId",theId);
        theQuery.executeUpdate();



    }
}
