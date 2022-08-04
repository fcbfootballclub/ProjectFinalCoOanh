package com.example.final_v1.ProductType.Service;
import com.example.final_v1.ProductType.Model.ProductType;
import com.example.final_v1.ProductType.Repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public int updateProductType(long id, ProductType productType) {
        Optional<ProductType> found = productTypeRepository.findById(id);
        if(found.isPresent()){
            found.get().setProduct_type(productType.getProduct_type());
            productTypeRepository.save(found.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteProductType(long id) {
        Optional<ProductType> found = productTypeRepository.findById(id);
        if(found.isPresent()){
            productTypeRepository.delete(found.get());
            return 1;
        }
        return 0;
    }

}
