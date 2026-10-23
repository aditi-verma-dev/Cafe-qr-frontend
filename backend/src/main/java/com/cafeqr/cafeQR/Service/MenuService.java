package com.cafeqr.cafeQR.Service;

import com.cafeqr.cafeQR.Entity.Category;
import com.cafeqr.cafeQR.Entity.MenuItem;
import com.cafeqr.cafeQR.Repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public List<MenuItem> getItemsByCategory(Category category) {
        return menuItemRepository.findByCategory(category);
    }
}