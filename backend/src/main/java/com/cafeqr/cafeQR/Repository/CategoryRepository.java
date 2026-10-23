package com.cafeqr.cafeQR.Repository;

import com.cafeqr.cafeQR.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}