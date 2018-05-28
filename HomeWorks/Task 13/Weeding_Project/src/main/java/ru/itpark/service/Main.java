package ru.itpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import ru.itpark.service.Configs.ContextApp;
import ru.itpark.service.Repositories.GoodRepositoryImpl;
import ru.itpark.service.Repositories.GoodsRepository;
import ru.itpark.service.models.Good;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext();

        DataSource source = (DataSource) context.getBean("dataSource");



        GoodsRepository repository = new GoodRepositoryImpl(source);

        Good good = Good.builder()
                .type("photography")
                .name("Best WEdding DAy")
                .composition("100-150 photo and fuck you")
                .description("fuck you")
                .price(150000.00)
                .build();

        repository.save(good);



    }


}
