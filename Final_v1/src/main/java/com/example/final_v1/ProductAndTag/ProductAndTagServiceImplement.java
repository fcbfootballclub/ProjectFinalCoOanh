package com.example.final_v1.ProductAndTag;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductAndTagServiceImplement implements ProductAndTagService {
    @Autowired
    ProductAndTagRepository productAndTagRepository;

    @Override
    public List<ProductAndTag> getAll() {
        return productAndTagRepository.findAll();
    }

    @Override
    public void addProductAndTag(ProductAndTag productAndTag) {
        productAndTagRepository.save(productAndTag);
    }

}
