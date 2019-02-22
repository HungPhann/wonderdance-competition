package tk.wonderdance.competition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tk.wonderdance.competition.model.audit.DateAudit;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "competition_user")
public class User extends DateAudit {

    @Id
    private long id;

    @OneToMany(mappedBy = "host", fetch = FetchType.LAZY)
    private Set<Competition> hostCompetitions;

    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    private Set<Team> teams;
}
