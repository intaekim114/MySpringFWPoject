package mylab.customer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mylab.customer.dao.mapper.CustomerMapper;
import mylab.customer.vo.CustomerVO;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public void insertCustomer(CustomerVO customer) {
		customerMapper.insertCustomer(customer);
	}

	@Override
	public List<CustomerVO> selectAllCustomer() {
		return customerMapper.selectAllCustomer();
	}

	@Override
	public CustomerVO selectCustomer(int id) {
		return customerMapper.selecCustomerById(id);
	}
}
