package com.killbug.user.api.domain;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.killbug.common.annotation.Sensitive;
import com.killbug.common.domain.BaseEntity;
import com.killbug.common.enums.SensitiveStrategy;
import com.killbug.common.xss.Xss;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Zch
 * @date 2023/8/19
 **/
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class User extends BaseEntity {

    @TableId(value = "user_id")
    private Long userId;

    @Xss(message = "script cannot exist in username")
    @NotBlank(message = "username cannot be null")
    @Size(min = 0, max = 30, message = "username length cannot exceed 30 chars")
    private String username;

    @Xss(message = "script cannot exist in nickname")
    @Size(min = 0, max = 30, message = "nickname length cannot exceed 30 chars")
    private String nickname;

    @Sensitive(strategy = SensitiveStrategy.EMAIL)
    @Email(message = "email format is incorrect")
    @Size(min = 0, max = 50, message = "email length cannot exceed 50 chars")
    private String email;

    @Sensitive(strategy = SensitiveStrategy.PHONE)
    private String phone;

    private String sex;

    private String avatar;

    @TableField(
            insertStrategy = FieldStrategy.NOT_EMPTY,
            updateStrategy = FieldStrategy.NOT_EMPTY,
            whereStrategy = FieldStrategy.NOT_EMPTY
    )
    private String password;

    private String position;

    private String company;

    private String website;

    private String introduction;

    private String status;

    private Integer balance;
}
