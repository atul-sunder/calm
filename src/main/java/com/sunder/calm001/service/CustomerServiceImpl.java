package com.sunder.calm001.service;

import com.sunder.calm001.entity.Customer;
import com.sunder.calm001.model.CustomerCreationReq;
import com.sunder.calm001.model.CustomerCreationResp;
import com.sunder.calm001.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl  implements  CustomerService{

    @Autowired
    CustomerRepo customerRepo;




    @Override
    public CustomerCreationResp createCustomer(CustomerCreationReq customerReq) {

        if (customerReq ==null || customerReq.getName() ==null|| customerReq.getName().isEmpty()){

            CustomerCreationResp customerCreationResp = new CustomerCreationResp();
            customerCreationResp.setName("");
            customerCreationResp.setMessage("Customer Name cannot null or Empty");
            customerCreationResp.setCode(400);

            return customerCreationResp;

        }

        //TODO: Atul need better approach for Exception handeling better

        Customer customerToBeSaved = new Customer();
        customerToBeSaved.setName(customerReq.getName());
        customerToBeSaved.setId(Long.valueOf(customerReq.getId()));

         try {

             Customer customerSaved = customerRepo.save(customerToBeSaved);
             CustomerCreationResp customerCreationResp = new CustomerCreationResp();

             customerCreationResp.setName(customerSaved.getName());
             customerCreationResp.setMessage("Customer Saved Successfully");
             customerCreationResp.setCode(200);

             return customerCreationResp;

         }catch (Exception ex)
         {
            System.err.println(ex);

             CustomerCreationResp customerCreationResp = new CustomerCreationResp();
             customerCreationResp.setName("");
             customerCreationResp.setMessage(ex.getMessage());
             customerCreationResp.setCode(500);
            return customerCreationResp;
         }


    }

    @Override
    public CustomerCreationResp getUser(Long id) {

        Optional<Customer> customer  =customerRepo.findById(id);

        if(customer.isPresent()){
            CustomerCreationResp customerCreationResp = new CustomerCreationResp();
            customerCreationResp.setName(customer.get().getName());
            customerCreationResp.setCode(200);
            customerCreationResp.setMessage("Customer RETRIEVED Successfully");

            return customerCreationResp;
        }
        else{

            CustomerCreationResp customerCreationResp = new CustomerCreationResp();
            customerCreationResp.setName("");
            customerCreationResp.setCode(404);
            customerCreationResp.setMessage("Customer not Found ");
            return customerCreationResp;
        }

    }


}
