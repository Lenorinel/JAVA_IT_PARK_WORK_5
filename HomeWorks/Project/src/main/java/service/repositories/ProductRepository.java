package service.repositories;

import service.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(nativeQuery = true, value = "DELETE * FROM product WHERE name = ?")
   Product deleteByProductName(String name);
}
