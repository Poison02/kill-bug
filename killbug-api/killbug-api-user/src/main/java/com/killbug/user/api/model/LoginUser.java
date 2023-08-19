package com.killbug.user.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Zch
 * @date 2023/8/19
 **/
@Data
@NoArgsConstructor
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private String username;

    private String nickname;

    private String email;

    private String phone;

    private String sex;

    private String avatar;

    private String token;

    private Integer balance;

    @JsonIgnore
    private String password;
}
