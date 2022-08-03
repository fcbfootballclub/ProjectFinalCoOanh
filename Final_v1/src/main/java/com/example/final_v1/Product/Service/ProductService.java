package com.example.final_v1.Product.Service;

import com.example.final_v1.Product.Model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAllProduct();
    public Optional<Product> getProductById(long id);
    public void addProduct(Product product);
    public void updateProduct(long id, Product product);
    public void deleteProduct(long id);
}
