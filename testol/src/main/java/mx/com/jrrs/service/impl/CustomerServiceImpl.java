package mx.com.jrrs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.jrrs.model.Customer;
import mx.com.jrrs.repository.CustomerRepository;
import mx.com.jrrs.service.CustomerService;
import mx.com.jrrs.vo.CustomerVO;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<CustomerVO> fetchAllCustomers() {
		List<CustomerVO> lstCustomer = new ArrayList<>();
		CustomerVO customerVO;
		for(Customer customer : customerRepository.findAll()){
			customerVO = new CustomerVO();
			customerVO.setId(customer.getId());
			customerVO.setName(customer.getName());
			customerVO.setAddress(customer.getAddress());
			customerVO.setPhone(customer.getPhone());
			lstCustomer.add(customerVO);
		}
		return lstCustomer;
	}

	@Override
	public void createCustomer(CustomerVO customerVO) {
		Customer customer = new Customer();
		customer.setName(customerVO.getName());
		customer.setAddress(customerVO.getAddress());
		customer.setPhone(customerVO.getPhone());
		customerRepository.save(customer);
	}

	@Override
	public void updateCustomer(CustomerVO customerVO) {
		Customer customer = new Customer();
		customer.setId(customerVO.getId());
		customer.setName(customerVO.getName());
		customer.setAddress(customerVO.getAddress());
		customer.setPhone(customerVO.getPhone());
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerRepository.delete(id);
	}

}
