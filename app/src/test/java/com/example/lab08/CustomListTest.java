package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {

    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        assertTrue(list.hasCity(calgary));
    }

    @Test
    public void testDeleteCity() {
        CustomList cityList = new CustomList();
        City city = new City("Calgary", "AB");
        cityList.addCity(city);

        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testCountCitiesWhenEmpty() {
        // should return 0
        CustomList cityList = new CustomList();

        int count = cityList.countCities();

        assertEquals(0, count);
    }

    @Test
    void testCountCities_WithMultipleCities() {
        CustomList cityList = new CustomList(); // Has 1 city
        City city2 = new City("Calgary", "Alberta");
        City city3 = new City("Winnipeg", "Manitoba");
        cityList.addCity(city2);
        cityList.addCity(city3);

        int count = cityList.countCities();

        assertEquals(3, count);
    }

    @Test
    void testCountCities_AfterAddAndDelete() {
        CustomList cityList = new CustomList();
        City city1 = new City("Halifax", "Nova Scotia");
        City city2 = new City("Fredericton", "New Brunswick");

        // Act & Assert
        assertEquals(0, cityList.countCities());

        cityList.addCity(city1);
        assertEquals(1, cityList.countCities());

        cityList.delete(city1);
        assertEquals(1, cityList.countCities());

        cityList.delete(city2);
        assertEquals(0, cityList.countCities());
    }
}
