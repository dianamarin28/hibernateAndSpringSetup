package com.myproject.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Client {

    @Column(insertable = false, updatable = false)
    private String firstName;

    @Column(insertable = false, updatable = false)
    private String lastName;

}
