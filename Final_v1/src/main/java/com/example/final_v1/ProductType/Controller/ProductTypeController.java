package com.example.final_v1.ProductType.Controller;
import com.example.final_v1.ProductType.Model.ProductType;
import com.example.final_v1.ProductType.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "product_type")
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;

    @GetMapping(path = "")
    List<ProductType> getAllProductType(){
        return productTypeService.getAllProductType();
    }

    @GetMapping(path = "{id}")
    Optional<ProductType> getProductTypeById(@PathVariable long id){
        return productTypeService.getProductTypeById(id);
    }

    @PostMapping(path = "")
    void addProductType(@RequestBody ProductType productType){
        productTypeService.addProductType(productType);
    }

    @PutMapping(path = "{id}")
    void updateProductType(@PathVariable long id, @RequestBody ProductType productType){
        productTypeService.updateProductType(id, productType);
    }

    @DeleteMapping(path = "{id}")
    void deleteProductType(@PathVariable long id){
        productTypeService.deleteProductType(id);
    }

}
