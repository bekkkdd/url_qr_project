package kz.bekdaulet.urlqrproject.controller;

import com.google.zxing.WriterException;
import kz.bekdaulet.urlqrproject.service.UrlMappingService;
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
        return urlMappingService.shortenUrl(longUrl.trim());
    }

    @GetMapping("/{id}")
    public String getLongUrl(@PathVariable String id) {
        return urlMappingService.getLongUrl(id.trim());
    }

    @GetMapping("/qr-code/{id}")
    public byte[] getQrCodeForShortenUrl(@PathVariable String id) throws IOException, WriterException {
        return urlMappingService.generateQrCode(id.trim());
    }
}
