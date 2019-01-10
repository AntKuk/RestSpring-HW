package com.netcracker.dao;

import com.netcracker.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("customerDAO")
@Transactional
public class CustomerDAOImpl extends BasicDAO implements ICustomerDAO {

    public List<Customer> findAllCustomers() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return criteria.list();
    }

    public Customer findCustomerById(int id) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("id",id));
        return (Customer) criteria.uniqueResult();
    }

    public void saveCustomer(Customer customer) {
        persist(customer);
    }

    public int deleteAllCustomers() {
        Query query = getSession().createQuery("delete from Customer");
        return query.executeUpdate();
    }

    public int deleteCustomerById(int id) {
        Query query = getSession().createQuery("delete from Customer where id = :id");
        query.setInteger("id",id);
        return query.executeUpdate();
    }

}
