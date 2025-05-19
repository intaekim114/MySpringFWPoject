package mylab.customer.dao.mapper;

import java.util.List;

import mylab.customer.vo.CustomerVO;

public interface CustomerMapper {
	CustomerVO selecCustomerById(int id);
	CustomerVO selectCustomerByEmail(String email);
	List<CustomerVO> selectAllCustomer();
	void insertCustomer(CustomerVO customerVO);
}
