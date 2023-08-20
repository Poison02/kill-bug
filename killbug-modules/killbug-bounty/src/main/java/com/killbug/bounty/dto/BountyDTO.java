package com.killbug.bounty.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@Data
@NoArgsConstructor
public class BountyDTO {

    @NotBlank(message = "title cannot be null")
    private String title;

    @NotBlank(message = "content cannot be null")
    private String content;

    @NotNull(message = "reward cannot be null")
    private Integer reward;

    @NotNull(message = "tags cannot be null")
    private List<String> tags;
}
