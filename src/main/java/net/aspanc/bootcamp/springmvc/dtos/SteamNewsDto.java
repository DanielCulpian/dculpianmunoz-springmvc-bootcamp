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

    @NotNull
    private String title;
    @NotNull
    private String url;
    @NotNull
    private String author;
    @NotNull
    private String contents;

}
