package com.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class DemoTable extends BaseEntity<String> {
    @Id
    private String id;
    private String name;

    protected DemoTable() {
        // Note: Required by JPA. Do not use.
    }

    public DemoTable(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .toString();
    }
}