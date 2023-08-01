package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.request.ItemRequest;
import com.veggie.veggieapp.dto.response.ItemResponse;
import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.model.Item;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper implements DtoMapper<ItemRequest, Item, ItemResponse> {


    private final AbstractCrudService<Food, Integer> foodService;

    @Autowired
    public ItemMapper(AbstractCrudService<Food, Integer> foodService) {
        this.foodService = foodService;
    }


    @Override
    public Item toEntity(ItemRequest itemRequest) {
        Food food = foodService.getById(itemRequest.foodId());


        Integer count = itemRequest.count();
        Float price = food.getPrice();

        return Item.builder()
                .food(food)
                .count(count)
                .unitPrice(price)
                .subtotal(count * price)
                .build();
    }

    @Override
    public ItemRequest toRequestDTO(Item item) {
        return null;
    }

    @Override
    public ItemResponse toResponseDTO(Item item) {
        return new ItemResponse(item.getFood().getName(), item.getUnitPrice(), item.getCount(), item.getSubtotal());
    }

}
