package jpabook.jpashop.service;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class updateItemDto {

    private Long itemId;
    private String name;
    private int price;
    private int StockQuantity;
}
