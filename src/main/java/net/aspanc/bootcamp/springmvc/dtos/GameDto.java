package net.aspanc.bootcamp.springmvc.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameDto {

    private Long id;

    @NotEmpty
    private String title;

    private String description;

    @Digits(integer = 9, fraction = 0)
    private Integer steamId;

    private Boolean played;

}
