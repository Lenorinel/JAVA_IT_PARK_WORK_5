import models.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class CustomersRepositoryImpl {
    private SessionFactory sessionFactory;
    private Session session;

    public CustomersRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.session = openSession();
    }

    public void customerSave() {
        Session session = openSession();
        Query<Customer> customerQuery =;
    }

    public List<Customer> findAll() {
        Session session = openSession();
        Query<Customer> customerQuery = session.createQuery("from Customer", Customer.class);
        return customerQuery.getResultList();

    }
    private Session openSession() {
        if (session != null && session.isOpen()){
            return  session;
        }else {
            return sessionFactory.openSession();
        }
    }
}
