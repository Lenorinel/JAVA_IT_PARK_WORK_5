package ru.itpark.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itpark.service.models.Customer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{

    //language=SQL
    private static final String SQL_FIND_BY_ALL =
            "SELECT * FROM customer";
    //language=SQL
    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM customer WHERE id=?";
    //language=SQL
    private static final String SQL_FIND_BY_LOGIN =
            "SELECT * FROM customer WHERE login = ?";
    //language=SQL
    private static final String SQL_SAVE_CUSTOMER =
            "INSERT INTO customer (login,hashpassword,firstname,lastname,email,address) " +
                    "VALUES (?,?,?,?,?,?)";
    //language=SQL
    private static final String SQL_DELETE_CUSTOMER_BY_ID =
            "DELETE FROM customer WHERE id = ?";

    private JdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Customer> customerRowMapper = new RowMapper<Customer>() {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Customer.builder()
                    .id(rs.getInt("id"))
                    .login(rs.getString("login"))
                    .hashPassword(rs.getString("hashpassword"))
                    .firstName(rs.getString("firstname"))
                    .lastName(rs.getString("lastname"))
                    .email(rs.getString("email"))
                    .address(rs.getString("address"))
                    .build();
        }
    };
    @Override
    public Customer find(int id) {
        List<Customer> customers = jdbcTemplate.query(SQL_FIND_BY_ID,customerRowMapper,id);
        if(customers.size() == 0)
            return null;
        else return customers.get(0);
    }

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query(SQL_FIND_BY_ALL, customerRowMapper);
    }

    @Override
    public void save(Customer model) {
    jdbcTemplate.update(SQL_SAVE_CUSTOMER,model.getLogin(),model.getHashPassword(),model.getFirstName(),
            model.getLastName(),model.getEmail(),model.getAddress());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(SQL_DELETE_CUSTOMER_BY_ID,customerRowMapper,id);
    }

    @Override
    public Customer findByLogin(String login) {

        List<Customer> customers = jdbcTemplate.query(SQL_FIND_BY_LOGIN,customerRowMapper,login);
        if(customers.size() == 0)
            return null;
        else return customers.get(0);
    }
}
