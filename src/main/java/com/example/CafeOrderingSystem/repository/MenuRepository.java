package com.example.CafeOrderingSystem.repository;

import com.example.CafeOrderingSystem.entity.MenuItem;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuRepository {
    void addMenuItem(MenuItem menuItem);
    void updateMenuItem(MenuItem menuItem);
    void removeMenuItem(int itemId);
    List<MenuItem> getAllMenuItems();
    MenuItem getMenuItemById(int itemId);
}
