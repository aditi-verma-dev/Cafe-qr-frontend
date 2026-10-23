package com.cafeqr.cafeQR.Repository;

import com.cafeqr.cafeQR.Entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.cafeqr.cafeQR.Entity.Category;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

List<MenuItem> findByCategory(Category category);
}
