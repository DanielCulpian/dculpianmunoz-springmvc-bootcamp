package net.aspanc.bootcamp.springmvc.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameDto {

    private Long id;

    private String title;

    private String description;

    private Integer steamId;
}
