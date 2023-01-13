package com.naijagis4me.v1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request extends Base {

    @OneToOne
    @JoinColumn(name = "Id", insertable = false, updatable = false)
    private Skill skill;

    @OneToOne
    @JoinColumn(name = "Id", insertable = false, updatable = false)
    private Rating rating;

    @ManyToOne
    @JoinColumn(name = "Id", insertable = false, updatable = false)
    private Client client;

}
