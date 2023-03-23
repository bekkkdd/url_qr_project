package kz.bekdaulet.urlqrproject.service.impl;

import com.google.zxing.WriterException;
import jakarta.servlet.http.HttpServletResponse;
import kz.bekdaulet.urlqrproject.exception.UrlMappingNotFound;
import kz.bekdaulet.urlqrproject.model.UrlMapping;
import kz.bekdaulet.urlqrproject.repository.UrlMappingRepository;
import kz.bekdaulet.urlqrproject.service.UrlMappingService;
import kz.bekdaulet.urlqrproject.utils.QRCodeUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Ushkempirov Bekdaulet on 23.03.2023
 **/
@Service
@AllArgsConstructor
public class UrlMappingServiceImpl implements UrlMappingService {

    private UrlMappingRepository urlMappingRepository;
    private static final String DOMAIN_SHORT_URL = "https://short.ly/";

    @Override
    public String shortenUrl(String longUrl) {
        UUID uuid = UUID.nameUUIDFromBytes(longUrl.getBytes());

        return DOMAIN_SHORT_URL + urlMappingRepository.findById(uuid)
                .map(UrlMapping::getShortenUrl)
                .orElse(
                        urlMappingRepository.save(
                                        new UrlMapping(uuid,
                                                RandomStringUtils.randomAlphanumeric(9),
                                                longUrl)
                                ).getShortenUrl()
                );
    }

    @Override
    public String getLongUrl(String shortUrl) {
        return urlMappingRepository.findByShortenUrl(shortUrl)
                .map(UrlMapping::getLongUrl)
                .orElseThrow(UrlMappingNotFound::new);
    }

    @Override
    public byte[] generateQrCode(String id) throws IOException, WriterException {
        return QRCodeUtil.generateAndGetQRCodeImage(checkAndGetExistingShortenUrl(id));
    }

    private String checkAndGetExistingShortenUrl(String id){
        return DOMAIN_SHORT_URL + urlMappingRepository.findByShortenUrl(id)
                .map(UrlMapping::getShortenUrl)
                .orElseThrow(UrlMappingNotFound::new);
    }
}
