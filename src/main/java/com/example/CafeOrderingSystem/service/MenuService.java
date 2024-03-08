package com.example.CafeOrderingSystem.service;

import java.util.List;

import com.example.CafeOrderingSystem.entity.MenuItem;
import com.example.CafeOrderingSystem.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired         //Or can be a constructor    public MenuService(MenuRepository menuRepository) {
                       //this.menuRepository = menuRepository;
                       //    }
    private MenuRepository menuRepository;

    public void addMenuItem(MenuItem menuItem) {
        menuRepository.addMenuItem(menuItem);
    }

    public void updateMenuItem(MenuItem menuItem) {
        menuRepository.updateMenuItem(menuItem);
    }

    public void removeMenuItem(int itemId) {
        menuRepository.removeMenuItem(itemId);
    }

    public List<MenuItem> getAllMenuItems() {
        return menuRepository.getAllMenuItems();
    }

    public MenuItem getMenuItemById(int itemId) {
        return menuRepository.getMenuItemById(itemId);
    }
}
