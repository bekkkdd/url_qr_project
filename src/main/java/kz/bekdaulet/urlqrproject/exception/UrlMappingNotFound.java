package kz.bekdaulet.urlqrproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Ushkempirov Bekdaulet on 23.03.2023
 **/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UrlMappingNotFound extends RuntimeException{
}
