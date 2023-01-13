package com.naijagis4me.v1.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.naijagis4me.v1.enums.ArtisanVerificationStatus;
import com.naijagis4me.v1.enums.AvailabilityForWork;
import com.naijagis4me.v1.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Artisan extends Base {


    @Enumerated
    @Column(name = "verification_status", nullable = false)
    private ArtisanVerificationStatus verificationStatus;

    @Enumerated
    @Column(name = "availability_for_work", nullable = false)
    private AvailabilityForWork available;

    @Enumerated
    @Column(name = "task_status", nullable = false)
    private TaskStatus taskStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "artisan",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Skill> skill;

    @JsonIgnore
    @OneToMany(mappedBy = "artisanId", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<AccountDetails> accountDetails;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Person person;
}
