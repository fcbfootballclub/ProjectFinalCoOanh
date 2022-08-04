package com.example.final_v1.ProductType.Controller;

import com.example.final_v1.ProductType.Model.ProductType;
import com.example.final_v1.ProductType.Model.ResponseObj;
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
    List<ProductType> getAllProductType() {
        return productTypeService.getAllProductType();
    }

    @GetMapping(path = "{id}")
    ResponseObj getProductTypeById(@PathVariable long id) {
        Optional<ProductType> found = productTypeService.getProductTypeById(id);
        return found.map(s -> new ResponseObj("OK", "Request Susseccfully", s)).orElseGet(() -> new ResponseObj("Failed", "Not valid ID " + id, ""));
    }

    @PostMapping(path = "")
    void addProductType(@RequestBody ProductType productType) {
        productTypeService.addProductType(productType);
    }

    @PutMapping(path = "{id}")
    ResponseObj updateProductType(@PathVariable long id, @RequestBody ProductType productType) {
        int check = productTypeService.updateProductType(id, productType);
        if(check == 1){
            return new ResponseObj("Ok", "Update successfully!", productType);
        }
        else {
            return new ResponseObj("Failed", "Something wrong", "");
        }
    }

    @DeleteMapping(path = "{id}")
    ResponseObj deleteProductType(@PathVariable long id) {
        int check = productTypeService.deleteProductType(id);
        if(check == 1){
            return new ResponseObj("Oke", "Delete Success", "");
        }
        return new ResponseObj("Fail", "Not found id : " + id, "");
    }

}
