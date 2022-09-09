package com.saalim.rest.controller;

import com.saalim.rest.dao.Dao;
import com.saalim.rest.model.Item;
import com.saalim.rest.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private Dao dao;

    @GetMapping(path = "/", produces = "application/json")
    public Items getEmployees() {
        return dao.getItemsList();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Item getEmployees(@PathVariable String id) {
        Item employees = new Item();
        int flag = 0;

        for (int i = 0; i < dao.getItemsList().getItemList().size() && flag == 0; ++i)

            if (Objects.equals(dao.getItemsList().getItemList().get(i).getId(), id)) {
                employees = dao.getItemsList().getItemList().get(i);
                flag = 1;
            }

        return employees;
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Item addItem(@RequestBody Item newItem) {
        dao.addItem(newItem);
        return dao.getItemsList().getItemList().get(Integer.parseInt(newItem.getId()));
    }

    @PutMapping(path = "/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody Item item) {
        return dao.updateItem(id, item);
    }

    @DeleteMapping(path = "/{id}")
    public Item deleteItem(@PathVariable String id) {
        return dao.deleteItem(id);
    }
}
