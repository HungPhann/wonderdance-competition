package tk.wonderdance.competition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tk.wonderdance.competition.model.helper.DanceGenre;
import tk.wonderdance.competition.model.helper.Money;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "competition_competitionCategory")
public class CompetitionCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="competition_id")
    private Competition competition;


    @Column(name = "dance_genre")
    private DanceGenre danceGenre;


    @NotNull
    @Column(name = "number_of_team_members")
    private Integer numberOfTeamMembers;


    @Column(name = "description")
    private String description;


    @OneToMany(fetch = FetchType.EAGER, orphanRemoval=true)
    @JoinTable(name = "competition_competitionCategory_judge",
            joinColumns = {
                    @JoinColumn(name = "competitionCategory_id", referencedColumnName = "id", foreignKey =  @ForeignKey(name = "fk_competitionCategory_id")),
                    @JoinColumn(name = "competition_id", referencedColumnName = "competition_id", foreignKey =  @ForeignKey(name = "fk_competition_id")),
            }
    )
    private Set<Person> judges;


    @OneToMany(fetch = FetchType.EAGER, orphanRemoval=true)
    @JoinTable(name = "competition_competitionCategory_dj",
            joinColumns = {
                    @JoinColumn(name = "competitionCategory_id", referencedColumnName = "id", foreignKey =  @ForeignKey(name = "fk_competitionCategory_id")),
                    @JoinColumn(name = "competition_id", referencedColumnName = "competition_id", foreignKey =  @ForeignKey(name = "fk_competition_id")),
            }
    )
    private Set<Person> dj;


    @OneToMany(fetch = FetchType.EAGER, orphanRemoval=true)
    @JoinTable(name = "competition_competitionCategory_mc",
            joinColumns = {
                    @JoinColumn(name = "competitionCategory_id", referencedColumnName = "id", foreignKey =  @ForeignKey(name = "fk_competitionCategory_id")),
                    @JoinColumn(name = "competition_id", referencedColumnName = "competition_id", foreignKey =  @ForeignKey(name = "fk_competition_id")),
            }
    )
    private Set<Person> mc;


    @NotNull
    @Column(name = "number_of_max_participants")
    private Integer numberOfMaxParticipants;


    @OneToMany(mappedBy = "competitionCategory", fetch = FetchType.LAZY, orphanRemoval=true)
    private Set<Team> participants;


    @OneToMany(mappedBy = "competitionCategory", fetch = FetchType.LAZY, orphanRemoval=true)
    private Set<Prize> prizes;


    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "currency", column = @Column(name = "fee_currency", nullable = false)),
            @AttributeOverride(name = "amount", column = @Column(name = "fee_amount", nullable = false))
    })
    private Money fee;
}
