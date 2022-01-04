package service;

import dao.CustomerDao;
import model.Customer;

import java.util.List;

public class CustomerServiceImpl implements IService<Customer>{
   CustomerDao customerDao = new CustomerDao();
    @Override
    public List<Customer> getList() {
        return customerDao.getList();
    }

    @Override
    public void save(Customer customer) {
        customerDao.insert(customer);
        getList();
    }

    @Override
    public void update(int id, Customer customer) {
        customerDao.update(id,customer);
        getList();
    }

    @Override
    public void delete(int id) {
        customerDao.delete(id);
        getList();
    }
    public Customer checkLoginCustomer(String email, String password){
        List<Customer> customerList = customerDao.getList();
        for (Customer c: customerList) {
            if((c.getEmail().equals(email)|c.getPhone().equals(email)) && c.getPasswords().equals(password)){
                return  c;
            }
        }
        return null;
    }
}
