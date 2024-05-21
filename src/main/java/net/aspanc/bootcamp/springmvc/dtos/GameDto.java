package net.aspanc.bootcamp.springmvc.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameDto {

    private Long id;

    private String title;

    private String description;

    private Integer steamId;

}
