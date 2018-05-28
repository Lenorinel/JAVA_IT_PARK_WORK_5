import ru.itpark.service.repositories.CustomerRepository;
import ru.itpark.service.repositories.CustomerRepositoryImpl;
import ru.itpark.service.services.CustomerService;
import ru.itpark.service.services.CustomerServiceByDataBaseImpl;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceByDataBaseImpl(null);
        System.out.println(customerService.findAllCustomersFromDatabase());
    }
}
