package com.etisalat.sampletask.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ahmed Etman on 4/25/2018.
 */

@Root(name = "menu")
public class Menu implements Serializable {
    @ElementList(inline = true)
    private List<Item> item;

    public List<Item> getItems() {
        return item;
    }
}
