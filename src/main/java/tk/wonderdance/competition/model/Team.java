package tk.wonderdance.competition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "competition_team")
public class Team {

    @Id
    @Column(name = "team_id")
    private long id;

    @Column(name = "member_name")
    @NotNull
    private String member;

    @ManyToOne
    private CompetitionCategory competitionCategory;

    @ManyToOne
    private User creator;
}
