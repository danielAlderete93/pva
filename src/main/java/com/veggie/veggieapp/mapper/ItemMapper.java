package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.request.order.ItemRequestDTO;
import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.model.Item;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper implements DtoMapper<ItemRequestDTO, Item> {


    private final AbstractCrudService<Food, Integer> foodService;

    @Autowired
    public ItemMapper(AbstractCrudService<Food, Integer> foodService) {
        this.foodService = foodService;
    }


    @Override
    public Item toEntity(ItemRequestDTO itemRequestDTO) {
        Food food = foodService.getById(itemRequestDTO.foodId());


        Integer count = itemRequestDTO.count();
        Float price = food.getPrice();

        return Item.builder()
                .food(food)
                .count(count)
                .unitPrice(price)
                .subtotal(count * price)
                .build();
    }

    @Override
    public ItemRequestDTO toDTO(Item item) {
        return null;
    }

}
