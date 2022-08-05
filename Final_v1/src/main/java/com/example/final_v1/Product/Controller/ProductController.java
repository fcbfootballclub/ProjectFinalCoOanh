package com.example.final_v1.Product.Controller;
import com.example.final_v1.ErrorHandler.ResponseObj;
import com.example.final_v1.Product.Model.Product;
import com.example.final_v1.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path = "/page/{pageNo}")
    ResponseObj getAllProduct(@PathVariable int pageNo){
        int pageSize = 20;
        return new ResponseObj("OK", "Get all products", productService.findPaginate(pageNo,pageSize));
    }

    @GetMapping(path = "/{id}")
    ResponseObj getProductById(@PathVariable long id){
        Optional<Product> productById = productService.getProductById(id);
        return productById.map(s -> new ResponseObj("OK", "Found product", productById.get())).orElseGet(() -> new ResponseObj("Failed", "Not found product id: " + id, ""));
    }

    @PostMapping(path = "")
    ResponseObj addProduct(@RequestBody Product product){
        int check = productService.addProduct(product);
        if(check == 1){
            return new ResponseObj("OK", "add product successfully", product);
        }
        return new ResponseObj("Failed", "product not valid", product);
    }

    @PutMapping(path = "{id}")
    ResponseObj updateProduct(@PathVariable long id, @RequestBody Product product){
        int check = productService.updateProduct(id, product);
        if(check == 1){
            return new ResponseObj("OK", "Update successfully", product);
        }
        return new ResponseObj("Failed", "Updated failed", product);
    }

    @DeleteMapping(path = "{id}")
    ResponseObj deleteProduct(@PathVariable long id){
        int check = productService.deleteProduct(id);
        if(check == 1){
            return new ResponseObj("OK", "Delete successfuly", id);
        }
        return new ResponseObj("Failed", "Not found id :" + id, "");
    }
}
