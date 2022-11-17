package com.example.multipledatabaseconfigurationmysql.model.db1;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "view1")
@Immutable
public class View1 {
    @Id
    String name;
    String prodname;

    public View1(String name, String prodname) {
        this.name = name;
        this.prodname = prodname;
    }

    public View1() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }
}
