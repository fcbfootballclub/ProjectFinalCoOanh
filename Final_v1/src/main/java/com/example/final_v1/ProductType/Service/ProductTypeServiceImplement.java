package com.example.final_v1.ProductType.Service;
import com.example.final_v1.ProductType.Model.ProductType;
import com.example.final_v1.ProductType.Repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeServiceImplement implements ProductTypeService{
    @Autowired
    ProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> getAllProductType() {
        return productTypeRepository.findAll();
    }

    @Override
    public Optional<ProductType> getProductTypeById(long id) {
        return productTypeRepository.findById(id);
    }

    @Override
    public void addProductType(ProductType productType) {
        productTypeRepository.save(productType);
    }

    @Override
    public void updateProductType(long id, ProductType productType) {
        Optional<ProductType> found = productTypeRepository.findById(id);
        if(found.isPresent()){
            found.get().setProduct_type(productType.getProduct_type());
            productTypeRepository.save(found.get());
        }
    }

    @Override
    public void deleteProductType(long id) {
        productTypeRepository.deleteById(id);
    }

}
