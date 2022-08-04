package com.example.final_v1.ProductType.Service;
import com.example.final_v1.ProductType.Model.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductTypeService {
    public List<ProductType> getAllProductType();
    public Optional<ProductType> getProductTypeById(long id);
    public int addProductType(ProductType productType);
    public int updateProductType(long id, ProductType productType);
    public int deleteProductType(long id);
}
