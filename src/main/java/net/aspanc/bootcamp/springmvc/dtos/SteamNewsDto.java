package net.aspanc.bootcamp.springmvc.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SteamNewsDto {

    private String title;
    private String url;
    private String author;
    private String contents;

}
