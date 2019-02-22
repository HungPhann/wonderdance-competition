package tk.wonderdance.competition.model.helper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Address {
    @Column(name = "address_name")
    @NotBlank
    @NotNull
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Embedded
    private GeographicCoordinate geographicCoordinate;

    public Address(@NotBlank @NotNull String name, String city, String state, String country, GeographicCoordinate geographicCoordinate) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
        this.geographicCoordinate = geographicCoordinate;
    }
}
