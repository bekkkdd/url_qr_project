package kz.bekdaulet.urlqrproject.service;

import com.google.zxing.WriterException;
import jakarta.servlet.http.HttpServletResponse;
import kz.bekdaulet.urlqrproject.model.UrlMapping;

import java.io.IOException;

/**
 * Created by Ushkempirov Bekdaulet on 23.03.2023
 **/

public interface UrlMappingService {
    String shortenUrl(String longUrl);

    String getLongUrl(String shortenUrl);

    byte[] generateQrCode(String id) throws IOException, WriterException;
}
