package com.naijagis4me.v1.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account_id")
public class AccountDetails extends Base {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "account_id", nullable = false)
//    private Long accountId;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(nullable = false)
    private Long artisanId;

}
