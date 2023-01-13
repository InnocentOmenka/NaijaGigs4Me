package com.naijagis4me.v1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rating extends Base {

    @Column(nullable = false)
    private Long artisanId;

    private double ratingScaleNumber;

    @Column(length = 500)
    private String ratingContent;

    @Column(nullable = false)
    private Long requestId;
}
