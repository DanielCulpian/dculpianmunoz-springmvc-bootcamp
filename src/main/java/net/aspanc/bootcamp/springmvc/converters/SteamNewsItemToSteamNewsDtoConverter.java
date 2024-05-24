package net.aspanc.bootcamp.springmvc.converters;

import com.ibasco.agql.protocols.valve.steam.webapi.pojos.SteamNewsItem;
import net.aspanc.bootcamp.springmvc.dtos.SteamNewsDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class SteamNewsItemToSteamNewsDtoConverter implements Converter<SteamNewsItem, SteamNewsDto> {

    @Override
    public SteamNewsDto convert(SteamNewsItem steamNewsItem) {
        Assert.notNull(steamNewsItem, "The object cannot be nulll!");
        return SteamNewsDto.builder()
                           .title(steamNewsItem.getTitle())
                           .author(steamNewsItem.getAuthor())
                           .url(steamNewsItem.getUrl())
                           .contents(steamNewsItem.getContents())
                           .build();
    }

}
