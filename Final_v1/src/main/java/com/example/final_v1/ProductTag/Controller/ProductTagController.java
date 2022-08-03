package com.example.final_v1.ProductTag.Controller;

import com.example.final_v1.ProductTag.Model.ProductTag;
import com.example.final_v1.ProductTag.Service.ProductTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "product_tag")
public class ProductTagController {
    @Autowired
    ProductTagService productTagService;

    @GetMapping(path = "")
    List<ProductTag> getAllTag(){
        return productTagService.getAllTag();
    }

    @GetMapping(path = "{id}")
    Optional<ProductTag> getTagById(@PathVariable long id){
        return productTagService.getTagById(id);
    }

    @PostMapping(path = "")
    void addNewTag(@RequestBody ProductTag productTag) {
        productTagService.addTag(productTag);
    }

    @PutMapping(path = "{id}")
    void updateTag(@PathVariable long id, @RequestBody ProductTag productTag){
      productTagService.updateTag(id, productTag);
    }

    @DeleteMapping(path = "{id}")
    void deleteTag(long id){
        productTagService.deleteTag(id);
    }

}
