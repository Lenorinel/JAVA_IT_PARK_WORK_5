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
    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM customer WHERE id=?";


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
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void save(Customer model) {

    }
}
