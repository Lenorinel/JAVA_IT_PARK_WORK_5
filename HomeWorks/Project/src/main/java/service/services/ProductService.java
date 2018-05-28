package service.services;

import service.forms.ProductForm;
import service.models.Product;

import java.util.List;

public interface ProductService {
    void saveProduct(ProductForm product);
    void deleteByName(String name);
    List<Product> getAllProducts();
}
