package com.example.final_v1.ProductTag.Service;

import com.example.final_v1.Product.Model.Product;
import com.example.final_v1.ProductTag.Model.ProductTag;

import java.util.List;
import java.util.Optional;

public interface ProductTagService {
    public List<ProductTag> getAllTag();
    public Optional<ProductTag> getTagById(long id);
    public void addTag(ProductTag tag);
    public void updateTag(long id, ProductTag tag);
    public void deleteTag(long id);
}
