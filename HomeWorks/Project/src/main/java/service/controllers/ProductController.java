package service.controllers;


import service.forms.ProductForm;
import service.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.services.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public String getProductsPage (ModelMap model) {
        List<Product> products = service.getAllProducts();
        model.addAttribute("product", products);
        return "ProductPage";
    }

    @PostMapping("/users")
    public String addProduct(ProductForm product){
        service.saveProduct(product);
        return "redirect:/products";
    }

}
