package com.example.final_v1.Product.Service;

import com.example.final_v1.Product.Model.Product;
import com.example.final_v1.Product.Repository.ProductRepository;
import com.example.final_v1.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplement implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(long id, Product product) {
        Optional<Product> found = productRepository.findById(id);
        if(found.isPresent()){
            found.get().setTitle(product.getTitle());
            found.get().setDescription(product.getDescription());
            found.get().setPrice(product.getPrice());
            found.get().setProductTags(product.getProductTags());
            found.get().setUpdated_at(product.getUpdated_at());
            productRepository.save(found.get());
        }
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
