package tk.wonderdance.competition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "competition_team")
public class Team {

    @Id
    @Column(name = "team_id")
    private long id;

    @NotBlank
    @NotNull
    @Column(name = "team_name")
    private String team_name;


    @OneToMany(fetch = FetchType.EAGER, orphanRemoval=true)
    @JoinTable(name = "competition_team_member")
    private Set<Person> members;


    @ManyToOne
    private CompetitionCategory competitionCategory;


    @ManyToOne
    private Competition competition;


    @ManyToOne
    private User creator;
}
