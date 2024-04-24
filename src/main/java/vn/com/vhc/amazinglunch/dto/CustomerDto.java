package vn.com.vhc.amazinglunch.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private Integer customer_id;

    private String name;

    private String email;

    private Integer tableOrder_id;
}
