package cn.com.myproject.es.service;

import cn.com.myproject.es.bean.Customer;
import cn.com.myproject.es.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements  ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findOne(String id) {
        return customerRepository.findById(id);
    }


}
