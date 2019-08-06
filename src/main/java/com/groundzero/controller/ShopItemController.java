package com.groundzero.controller;

import com.groundzero.data.entities.ShopItem;
import com.groundzero.data.repositories.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/shop_items")
public class ShopItemController {

    private static final String NAME = "ShopItem";
    private static final String ID = "Id";

    @Autowired
    ShopItemRepository shopitemRepository;

    @GetMapping("/all")
    public List<ShopItem> getShopItems() {
        return shopitemRepository.findAll();
    }

    @PostMapping("/add")
    public ShopItem addShopItem(@Valid @RequestBody ShopItem shopItem) {
        return shopitemRepository.save(shopItem);
    }

    @GetMapping("/single/{id}")
    public ShopItem getSingleShopItem(@PathVariable(value = "id") long id) {
        return shopitemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NAME, ID, id));
    }

    @PutMapping("/single/{id}")
    public ShopItem updateSingleShopItem(@PathVariable(value = "id") long id, @Valid @RequestBody ShopItem newShopItem) {
        ShopItem databaseShopItem =
                shopitemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NAME, ID, id));

        databaseShopItem.updateItem(newShopItem);
        return shopitemRepository.save(databaseShopItem);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteSingleShopitem(@PathVariable(value = "id") long id) {

        ShopItem shopItem =
                shopitemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NAME, ID, id));
        shopitemRepository.delete(shopItem);

        return ResponseEntity.ok().build();
    }


}
