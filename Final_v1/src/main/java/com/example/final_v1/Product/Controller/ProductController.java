package com.example.final_v1.Product.Controller;
import com.example.final_v1.Product.Model.Product;
import com.example.final_v1.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path = "")
    List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping(path = "/{id}")
    Optional<Product> getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }

    @PostMapping(path = "")
    void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @PutMapping(path = "{id}")
    void updateProduct(@PathVariable long id, @RequestBody Product product){
        productService.updateProduct(id, product);
    }

    @DeleteMapping(path = "{id}")
    void deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
    }
}
