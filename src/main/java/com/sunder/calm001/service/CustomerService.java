package com.sunder.calm001.service;

import com.sunder.calm001.model.CustomerCreationReq;
import com.sunder.calm001.model.CustomerCreationResp;

public interface CustomerService {

   CustomerCreationResp createCustomer(CustomerCreationReq customerReq);

   CustomerCreationResp getUser(Long id);
}
