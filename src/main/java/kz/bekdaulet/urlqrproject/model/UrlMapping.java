package kz.bekdaulet.urlqrproject.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * Created by Ushkempirov Bekdaulet on 23.03.2023
 **/
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlMapping {

    @Id
    @Column(updatable = false, nullable = false)
    protected UUID id;

    @Column(name = "shorten_url", updatable = false, nullable = false, unique = true, length = 50)
    private String shortenUrl;

    @Column(name = "long_url", length = 5000)
    private String longUrl;
}
