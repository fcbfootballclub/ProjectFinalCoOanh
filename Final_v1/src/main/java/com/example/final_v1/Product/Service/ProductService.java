package com.example.final_v1.Product.Service;

import com.example.final_v1.Product.Model.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAllProduct();
    public Optional<Product> getProductById(long id);
    public int addProduct(Product product);
    public int updateProduct(long id, Product product);
    public int deleteProduct(long id);

    public Page<Product> findPaginate(int pageNo, int pageSize);
}
