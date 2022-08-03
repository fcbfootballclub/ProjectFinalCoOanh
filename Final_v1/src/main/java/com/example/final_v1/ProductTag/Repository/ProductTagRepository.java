package com.example.final_v1.ProductTag.Repository;

import com.example.final_v1.ProductTag.Model.ProductTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTagRepository extends JpaRepository<ProductTag, Long> {
}
