package com.example.demo1.service;

import com.example.demo1.model.Menu;
import com.example.demo1.repositery.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(int id) {
        return menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu not found"));
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(int id, Menu updatedMenu) {
        Menu existingMenu = getMenuById(id);
        existingMenu.setName(updatedMenu.getName());
        existingMenu.setDescription(updatedMenu.getDescription());
        existingMenu.setPrice(updatedMenu.getPrice());
        existingMenu.setAvailabilityStatus(updatedMenu.isAvailabilityStatus());
        return menuRepository.save(existingMenu);
    }

    public void deleteMenu(int id) {
        menuRepository.deleteById(id);
    }
}