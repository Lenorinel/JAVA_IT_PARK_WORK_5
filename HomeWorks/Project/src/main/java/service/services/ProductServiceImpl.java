package service.services;

import service.forms.ProductForm;
import service.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import service.repositories.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void saveProduct(ProductForm product) {
        Product newProduct = Product.builder()
                .productName(product.getProductName())
                .category(product.getCategory())
                .description(product.getDescription())
                .productPrice(product.getProductPrice())
                .build();
        productRepository.save(newProduct);
    }


    @Override
    public void deleteByName(String name) {
        productRepository.deleteByProductName(name);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return  products;
    }
}
