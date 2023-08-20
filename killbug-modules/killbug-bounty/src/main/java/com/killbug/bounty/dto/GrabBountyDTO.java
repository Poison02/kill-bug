package com.killbug.bounty.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@Data
@NoArgsConstructor
public class GrabBountyDTO {

    @NotBlank(message = "id cannot be null")
    private String id;

    //@NotBlank(message = "solverId cannot be null")
    //private String solverId;
}
