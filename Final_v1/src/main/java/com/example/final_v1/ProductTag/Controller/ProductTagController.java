package com.example.final_v1.ProductTag.Controller;
import com.example.final_v1.ErrorHandler.ResponseObj;
import com.example.final_v1.ProductTag.Model.ProductTag;
import com.example.final_v1.ProductTag.Service.ProductTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(path = "product_tag")
public class ProductTagController {
    @Autowired
    ProductTagService productTagService;

    @GetMapping(path = "")
    ResponseObj getAllTag(){
        return new ResponseObj("OK", "Get all products", productTagService.getAllTag());
    }

    @GetMapping(path = "{id}")
    ResponseObj getTagById(@PathVariable long id){
        Optional<ProductTag> found = productTagService.getTagById(id);
        return found.map(productTag -> new ResponseObj("OK", "Found tag", productTag)).orElseGet(() -> new ResponseObj("Failed", "Not found id" + id, ""));
    }

    @PostMapping(path = "")
    ResponseObj addNewTag(@RequestBody ProductTag productTag) {
        int check = productTagService.addTag(productTag);
        if(check == 1) return new ResponseObj("OK", "Added successfully", productTag);
        return new ResponseObj("Failed", "Not valid tag", "");
    }

    @PutMapping(path = "{id}")
    ResponseObj updateTag(@PathVariable long id, @RequestBody ProductTag productTag){
        int check = productTagService.updateTag(id, productTag);
        if(check == 1) return new ResponseObj("OK", "Add tag successfully", productTag);
        return new ResponseObj("Failed", "Update tag failed", productTag);
    }

    @DeleteMapping(path = "{id}")
    ResponseObj deleteTag(@PathVariable long id){
        int check = productTagService.deleteTag(id);
        if(check == 1){
            return new ResponseObj("OK", "Delete successfully", "");
        }
        return new ResponseObj("Failed", "Delete failed", "");
    }

}
