package tk.wonderdance.competition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "competition_category_prize")
public class Prize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    @NotNull
    @NotBlank
    private String title;

    @Column(name = "reward")
    @NotNull
    @NotBlank
    private String reward;

    @ManyToOne
    private CompetitionCategory competitionCategory;

    @ManyToOne
    private Competition competition;
}
