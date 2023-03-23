package kz.bekdaulet.urlqrproject.repository;

import kz.bekdaulet.urlqrproject.model.UrlMapping;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by Ushkempirov Bekdaulet on 23.03.2023
 **/
public interface UrlMappingRepository extends CrudRepository<UrlMapping, UUID> {
    Optional<UrlMapping> findByShortenUrl(String shortenUrl);
}
