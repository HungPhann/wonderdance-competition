package tk.wonderdance.competition.model.helper;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class GeographicCoordinate {
    @Column(name = "lng")
    @NotNull
    private Float longitude;

    @Column(name = "lat")
    @NotNull
    private Float latitude;

    public GeographicCoordinate(@NotNull Float longitude, @NotNull Float latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
