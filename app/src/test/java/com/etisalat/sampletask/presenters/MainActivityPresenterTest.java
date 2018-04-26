package com.etisalat.sampletask.presenters;

import com.etisalat.sampletask.bases.BasePresenterListener;
import com.etisalat.sampletask.models.Item;
import com.etisalat.sampletask.views.MainActivityListener;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Ahmed Etman on 4/26/2018.
 */
public class MainActivityPresenterTest {

    MainActivityPresenter mainActivityPresenter;

    @Mock
    BasePresenterListener basePresenterListener;

    @Mock
    MainActivityListener mainActivityListener;

    @Before
    public void setUp() throws Exception {
        mainActivityPresenter = new MainActivityPresenter(basePresenterListener, mainActivityListener);
    }

    @Test
    public void sortFoodList() throws Exception {

        List<Item> itemsAfterSort = mainActivityPresenter.sortFoodList(prepareListToSort());
        Object[] actual = itemsAfterSort.toArray();
        Object[] expected = prepareExpectedSortedList().toArray();
        Assert.assertArrayEquals(actual,expected);
    }

    private List<Item> prepareListToSort() {
        List<Item> itemList = new ArrayList<>();

        Item item1 = new Item();
        item1.setName("Margherita");
        item1.setCost("120");
        item1.setId("1");
        item1.setDescription("test");

        Item item2 = new Item();
        item2.setName("Barbeque Chicken");
        item2.setCost("135");
        item2.setId("2");
        item2.setDescription("test");

        Item item3 = new Item();
        item3.setName("Spicy Chicken");
        item3.setCost("265");
        item3.setId("3");
        item3.setDescription("test");


        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);

        return itemList;
    }

    private List<Item> prepareExpectedSortedList() {
        List<Item> itemList = new ArrayList<>();

        Item item1 = new Item();
        item1.setName("Barbeque Chicken");
        item1.setCost("135");
        item1.setId("2");
        item1.setDescription("test");


        Item item2 = new Item();
        item2.setName("Margherita");
        item2.setCost("120");
        item2.setId("1");
        item2.setDescription("test");


        Item item3 = new Item();
        item3.setName("Spicy Chicken");
        item3.setCost("265");
        item3.setId("3");
        item3.setDescription("test");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);

        return itemList;
    }
}