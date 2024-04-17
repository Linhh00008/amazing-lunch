package vn.com.vhc.amazinglunch.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private Integer order_id;

    private Integer tableOrder_id;

    private Integer food_id;
}
