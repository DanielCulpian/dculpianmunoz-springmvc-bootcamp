package net.aspanc.bootcamp.springmvc.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {

    private Long id;

    private String title;

    private String descrition;

    private Integer steamId;

}
