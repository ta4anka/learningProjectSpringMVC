package tk.ta4anka.springmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.ta4anka.springmvc.entity.Customer;
import tk.ta4anka.springmvc.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject our customer service
    @Autowired
    private CustomerService customerService; //Spring will scan for a component that implements CustomerDAO interface --> @Repository

    @GetMapping("/list")
    public String listCustomer(Model theModel){

        // get customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the Spring Model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to bind form data
        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }


    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        // save the customer using our service
        customerService.save(theCustomer);

        return "redirect:/customer/list";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){

        // get the customer from the database
        Customer theCustomer = customerService.getById(theId);

        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

        // send over to our form
        return "customer-form";
    }


    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){

        customerService.deleteById(theId);

        return "redirect:/customer/list";
    }

}


