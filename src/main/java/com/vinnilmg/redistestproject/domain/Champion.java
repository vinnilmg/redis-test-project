package com.vinnilmg.redistestproject.domain;

import java.io.Serializable;

public class Champion implements Serializable {
    private Integer id;
    private String name;
    private String position;

    public Champion() {
    }

    public Champion(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public Champion(Integer id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

}
