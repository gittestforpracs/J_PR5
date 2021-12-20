package com.boots.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Reserv {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String ApplicationType;

    private String ConnectionType;

    private String YourName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicationType() {
        return ApplicationType;
    }

    public void setApplicationType(String ApplicationType) {
        this.ApplicationType = ApplicationType;
    }

    public String getConnectionType() {
        return ConnectionType;
    }

    public void setConnectionType(String ConnectionType) {
        this.ConnectionType = ConnectionType;
    }

    public Reserv() {
    }

    public Reserv(String ApplicationType, String ConnectionType, String name) {
        this.ApplicationType = ApplicationType;
        this.ConnectionType = ConnectionType;
        this.YourName = YourName;
    }

    public String getName() {
        return YourName;
    }

    public void setName(String name) {
        this.YourName = YourName;
    }
}