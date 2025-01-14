package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * Get the list of cities
     * Check if the desired city is in list
     * Returns true or false of whether it exists or not
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city1 = new City("testA", "testB");
        list.addCity(city1);

        assertTrue(list.hasCity(city1));

        City city2 = new City("testC", "testD");
        assertFalse(list.hasCity(city2));

    }

    /**
     * Get the city list
     * Remove the city provided from the list
     * Check the length of the city list
     * Should be one less
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city1 = new City("testA", "testB");

        list.addCity(city1);
        assertEquals(list.getCount(), 1);
        assertTrue(list.deleteCity(city1));
        assertEquals(list.getCount(), 0);

        assertFalse(list.deleteCity(city1));
    }

    /**
     * Get the list of cities
     * Add a new city
     * Check if length has increased by one
     * Add another city
     * Check if length has increased by one
     * Delete a city
     * Check length of list
     * Delete a city
     * Check length of list
     */
    @Test
    public void countCitiesTest() {
        list = MockCityList();
        assertEquals(0, list.countCities());

        City city1 = new City("testA", "testB");
        list.addCity(city1);
        assertEquals(1, list.countCities());

        City city2 = new City("testC", "testD");
        list.addCity(city2);
        assertEquals(2, list.countCities());

        list.deleteCity(city1);
        assertEquals(1, list.countCities());

        list.deleteCity(city2);
        assertEquals(0, list.countCities());
    }
}
