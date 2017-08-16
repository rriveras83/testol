package mx.com.jrrs.service;

import java.util.List;

import mx.com.jrrs.vo.CustomerVO;

public interface CustomerService {
	List<CustomerVO> fetchAllCustomers();
	void createCustomer(CustomerVO customerVO);
	void updateCustomer(CustomerVO customerVO);
	void deleteCustomer(Integer id);
}
