package com.etisalat.sampletask.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Ahmed Etman on 4/25/2018.
 */

@Root(name = "item")
public class Item {
    @Element(name = "id")
    private String id;

    @Element(name = "description")
    private String description;

    @Element(name = "name")
    private String name;

    @Element(name = "cost")
    private String cost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj != null && obj instanceof Item) {
            Item newItem = (Item) obj;
            if (newItem.getName().equals(this.getName()) &&
                    newItem.getCost().equals(this.getCost()) &&
                    newItem.getDescription().equals(this.getDescription()) &&
                    newItem.getId().equals(this.getId()))

                result = true;
        }
        return result;
    }
}
