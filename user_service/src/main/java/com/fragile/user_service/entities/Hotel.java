package com.fragile.user_service.entities;

import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Hotel {

    @Id
    private String hotelId;

    private String name;

    private String location;

    private String about;
}
