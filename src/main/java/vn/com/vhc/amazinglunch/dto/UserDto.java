package vn.com.vhc.amazinglunch.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Integer user_id;

    private String username;

    private String email;

    private Integer role_id;

    private String tokenPassword;

    private String tokenSession;
}
