package net.aspanc.bootcamp.springmvc.converters;

import com.ibasco.agql.protocols.valve.steam.webapi.pojos.StoreAppDetails;
import net.aspanc.bootcamp.springmvc.dtos.SteamGameDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class StoreAppDetailsToGameSteamDtoConverter implements Converter<StoreAppDetails, SteamGameDto> {

    @Override
    public SteamGameDto convert(StoreAppDetails storeAppDetails) {
        return SteamGameDto.builder()
                           .screenshotUrl(storeAppDetails.getScreenshots()
                                                         .get(new Random().nextInt(storeAppDetails.getScreenshots().size()))
                                                         .getFullPath())
                           .build();
    }

}
