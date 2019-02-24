package tk.wonderdance.competition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tk.wonderdance.competition.model.audit.DateAudit;
import tk.wonderdance.competition.model.helper.Address;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "competition_competition")
public class Competition extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User host;

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "background_picture")
    private String backgroundPicture;

    @Column(name = "start_date")
    @Basic
    private Date startDate;

    @Column(name = "start_time")
    @Basic
    private Time startTime;

    @Column(name = "end_date")
    @Basic
    private Date endDate;

    @Column(name = "end_time")
    @Basic
    private Time endTime;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "competition", fetch = FetchType.LAZY, orphanRemoval=true)
    private Set<CompetitionCategory> competitionCategories;

}
