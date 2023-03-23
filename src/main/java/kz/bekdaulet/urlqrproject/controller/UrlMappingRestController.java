package kz.bekdaulet.urlqrproject.controller;

import com.google.zxing.WriterException;
import kz.bekdaulet.urlqrproject.model.UrlMapping;
import kz.bekdaulet.urlqrproject.service.UrlMappingService;
import kz.bekdaulet.urlqrproject.utils.QRCodeUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by Ushkempirov Bekdaulet on 23.03.2023
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/url")
public class UrlMappingRestController {

    private UrlMappingService urlMappingService;

    @PostMapping("/shorten")
    public String createAndGetShortenUrl(@RequestBody String longUrl) {
        return urlMappingService.shortenUrl(longUrl);
    }

    @GetMapping("/{id}")
    public String getLongUrl(@PathVariable String id) {
        return urlMappingService.getLongUrl(id);
    }

    @GetMapping("/qr-code/{id}")
    public byte[] getQrCodeForShortenUrl(@PathVariable String id) throws IOException, WriterException {
        return urlMappingService.generateQrCode(id);
    }
}
