package ru.itpark.service.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itpark.service.models.Customer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {
    //language=SQL
    private static final String SQL_FIND_ALL =
            "SELECT * FROM customer";
    //language=SQL
    private static final String SQL_INSERT_CUSTOMER =
            "INSERT INTO customer (login, hash_password, first_name, secon_dname, email, birth_date, address, phone_number)" +
                    " VALUES (?,?,?,?,?,?,?,?)";
    //language=SQL
    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM customer WHERE id=?";
    //language=SQL
    private static final String SQL_DELETE_BY_LOGIN =
            "DELETE FROM customer  WHERE login = ? ";
    //language=SQL
    private static final String SQL_FIND_BY_LOGIN =
            "SELECT * FROM customer WHERE login=?";

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public CustomerRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Customer> rowMapper = new RowMapper<Customer>() {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Customer.builder()
                    .login(rs.getString("login"))
                    .hashPassword(rs.getString("hash_password"))
                    .firstName(rs.getString("first_name"))
                    .secondName(rs.getString("second_name"))
                    .email(rs.getString("email"))
                    .birthDate(rs.getDate("birth_date"))
                    .address(rs.getString("address"))
                    .phoneNumber(rs.getString("phone_number"))
                    .build();
        }
    };
    @Override
    public Customer find(int id) {
        List<Customer> customers = jdbcTemplate.query(SQL_FIND_BY_ID, rowMapper, id);
        if (customers.size() == 0) {
            return null;
        } else return customers.get(0);
    }

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL,rowMapper);
    }

    @Override
    public void save(Customer model) {
        jdbcTemplate.update(SQL_FIND_ALL,rowMapper, model.getLogin(),model.getHashPassword(),model.getFirstName(),
                model.getSecondName(),model.getEmail(),model.getBirthDate(),model.getAddress(),model.getPhoneNumber());
    }

    @Override
    public void delete(String login) {
        jdbcTemplate.update(SQL_DELETE_BY_LOGIN,rowMapper,login);
    }

    @Override
    public Customer findByLogin(String login) {
        List<Customer> customers = jdbcTemplate.query(SQL_FIND_BY_LOGIN, rowMapper, login);
        if (customers.size() == 0) {
            return null;
        } else return customers.get(0);
    }
}
