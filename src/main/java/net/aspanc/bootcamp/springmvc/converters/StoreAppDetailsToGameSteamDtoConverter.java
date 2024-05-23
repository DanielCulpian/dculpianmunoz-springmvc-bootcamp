package net.aspanc.bootcamp.springmvc.converters;

import com.ibasco.agql.protocols.valve.steam.webapi.pojos.StoreAppDetails;
import net.aspanc.bootcamp.springmvc.dtos.GameSteamDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class StoreAppDetailsToGameSteamDtoConverter implements Converter<StoreAppDetails, GameSteamDto> {

    private final Random random = new Random();

    @Override
    public GameSteamDto convert(StoreAppDetails storeAppDetails) {
        return GameSteamDto.builder()
                           .screenshotUrl(storeAppDetails.getScreenshots()
                                                         .get(random.nextInt() * storeAppDetails.getScreenshots()
                                                                                                .size())
                                                         .getFullPath())
                           .build();
    }

}
