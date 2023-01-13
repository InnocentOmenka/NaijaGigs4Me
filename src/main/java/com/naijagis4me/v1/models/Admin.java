package com.naijagis4me.v1.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class Admin extends Base {
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Person person;


}
