package com.example.final_v1.ProductAndTag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAndTagRepository extends JpaRepository<ProductAndTag, Long> {

}
