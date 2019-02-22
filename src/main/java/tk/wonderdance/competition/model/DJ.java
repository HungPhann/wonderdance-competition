package tk.wonderdance.competition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "competition_dj")
public class DJ implements Serializable {
    @Column(name = "name")
    @NotNull
    @NotBlank
    @Id
    private String name;

    @ManyToOne
    @Id
    private CompetitionCategory competitionCategory;
}
