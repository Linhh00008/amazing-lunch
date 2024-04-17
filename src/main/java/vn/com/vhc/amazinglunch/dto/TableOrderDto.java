package vn.com.vhc.amazinglunch.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableOrderDto {
    private Integer tableOrder_id;

    private Integer restaurant_id;

    private String name;

    private Integer maxPerson;

    private Integer numberCurrentPerson;

}
