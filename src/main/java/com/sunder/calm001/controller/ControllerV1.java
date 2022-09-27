package com.sunder.calm001.controller;


import com.sunder.calm001.model.CustomerCreationReq;
import com.sunder.calm001.model.CustomerCreationResp;
import com.sunder.calm001.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerV1 {

    @Autowired
    CustomerService customerService;


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);


        return "greeting";
    }

    @GetMapping("/customer")
    public String getUser(@RequestParam(name="id", required=true) Long id, Model model) {

       CustomerCreationResp customerCreationResp = customerService.getUser(id);

        model.addAttribute("name", customerCreationResp.getName());


        return "greeting";
    }


    @PostMapping("/create/customer")
    public String create(@RequestBody CustomerCreationReq customerReq, Model model) {


        CustomerCreationResp customerCreationResp = customerService.createCustomer(customerReq);


        if (customerCreationResp.getCode() ==200)
        {
            model.addAttribute("name", customerCreationResp.getName());
        }


        return "createUser";
    }
}



