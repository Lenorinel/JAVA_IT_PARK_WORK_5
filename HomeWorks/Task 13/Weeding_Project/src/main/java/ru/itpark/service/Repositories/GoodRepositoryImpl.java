package ru.itpark.service.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itpark.service.models.Good;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class GoodRepositoryImpl implements GoodsRepository {
    //language=SQL
    private static final String SQL_FIND_ALL =
            "SELECT * FROM good";
    //language=SQL
    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM good WHERE id=?";
    //language=SQL
    private static final String SQL_INSERT_GOOD =
            "INSERT INTO good (type, name, composition, description, price) VALUES (?,?,?,?,?)";
    //language=SQL
    private static final String SQL_DELETE_BY_NAME =
            "DELETE * FROM good WHERE name = ? ";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GoodRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Good> rowMapper = new RowMapper<Good>() {
        @Override
        public Good mapRow(ResultSet row, int rowNum) throws SQLException {
            return Good.builder()
                    .id(row.getInt("id"))
                    .type(row.getString("type"))
                    .name(row.getString("name"))
                    .composition(row.getString("composition"))
                    .description(row.getString("discription"))
                    .price(row.getDouble("price"))
                    .build();

        }
    };

    @Override
    public Good find(int id) {
        List<Good> goods = jdbcTemplate.query(SQL_FIND_BY_ID, rowMapper, id);
        if (goods.size() == 0) {
            return null;
        } else return goods.get(0);
    }

    @Override
    public List<Good> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL,rowMapper);
    }

    @Override
    public void save(Good model) {
        jdbcTemplate.update(SQL_INSERT_GOOD,rowMapper, model.getType(),model.getName(),model.getComposition()
        ,model.getDescription(),model.getPrice());
    }

    @Override
    public void delete(String name) {
        jdbcTemplate.update(SQL_DELETE_BY_NAME,rowMapper,name);
    }
}
