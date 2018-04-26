package com.etisalat.sampletask.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Ahmed Etman on 4/25/2018.
 */

@Root(name = "menu")
public class Menu {
    @ElementList(inline = true)
    private List<Item> item;

    public List<Item> getItems() {
        return item;
    }
}
