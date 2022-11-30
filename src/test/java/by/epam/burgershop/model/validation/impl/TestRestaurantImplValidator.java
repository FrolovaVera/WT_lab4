package by.epam.burgershop.model.validation.impl;

import by.epam.burgershop.model.validation.RestaurantValidator;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRestaurantImplValidator {
    private static final String BLOCK = "block";
    private static final String NUMBER = "number";
    private static final String CITY = "city";
    private static final String STREET = "street";
    private static final String HOUSE = "house";
    private RestaurantValidator restaurantValidator;
    private Map<String, String> mapData;
    private String number;
    private String incorrectNumber;
    private String longNumber;
    private String negativeNumber;
    private String zero;
    private String emptyString;
    private String longText;
    private String city;
    private String street;
    private String house;

    @BeforeEach
    public void setUp() {
        restaurantValidator = RestaurantValidatorImpl.getInstance();
        number = "10";
        city = "Brest";
        street = "Minskaya";
        house = "10a";
        incorrectNumber = "Hello";
        longNumber = "158621431845632";
        negativeNumber = "-2";
        zero = "0";
        emptyString = "\s";
        mapData = new LinkedHashMap<>();
        mapData.put(NUMBER, number);
        mapData.put(CITY, city);
        mapData.put(STREET, street);
        mapData.put(HOUSE, house);
        mapData.put(BLOCK, number);
        longText = """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
                incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat
                nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa
                qui officia deserunt mollit anim id est laborum.
                """;

    }

    @Test
    public void isValidFormTest() {
        boolean actualResult = restaurantValidator.isValidForm(mapData);
        assertTrue(actualResult);
    }

    @Test
    public void isValidFormFalseTest() {
        mapData.put(STREET, emptyString);
        boolean actualResult = restaurantValidator.isValidForm(mapData);
        assertFalse(actualResult);
    }

    @Test
    public void isValidNumberTest() {
        boolean actualResult = restaurantValidator.isValidNumber(number);
        assertTrue(actualResult);
    }

    @Test
    public void isValidNumberFalseTest() {
        boolean actualResult = restaurantValidator.isValidNumber(incorrectNumber);
        assertFalse(actualResult);
    }

    @Test
    public void isValidNumberLongNumberFalseTest() {
        boolean actualResult = restaurantValidator.isValidNumber(longNumber);
        assertFalse(actualResult);
    }

    @Test
    public void isValidNumberNegativeNumberFalseTest() {
        boolean actualResult = restaurantValidator.isValidNumber(negativeNumber);
        assertFalse(actualResult);
    }

    @Test
    public void isValidNumberZeroFalseTest() {
        boolean actualResult = restaurantValidator.isValidNumber(zero);
        assertFalse(actualResult);
    }

    @Test
    public void isValidNumberEmptyStringFalseTest() {
        boolean actualResult = restaurantValidator.isValidNumber(emptyString);
        assertFalse(actualResult);
    }

    @Test
    public void isValidCityOrStreetTest() {
        boolean actualResult = restaurantValidator.isValidCityOrStreet(city);
        assertTrue(actualResult);
    }

    @Test
    public void isValidCityOrStreetEmptyStringFalseTest() {
        boolean actualResult = restaurantValidator.isValidCityOrStreet(emptyString);
        assertFalse(actualResult);
    }

    @Test
    public void isValidCityOrStreetLongTextFalseTest() {
        boolean actualResult = restaurantValidator.isValidCityOrStreet(longText);
        assertFalse(actualResult);
    }

    @Test
    public void isValidHouseTest() {
        boolean actualResult = restaurantValidator.isValidHouse(number);
        assertTrue(actualResult);
    }

    @Test
    public void isValidHouseEmptyStringFalseTest() {
        boolean actualResult = restaurantValidator.isValidHouse(emptyString);
        assertFalse(actualResult);
    }

    @Test
    public void isValidHouseLongTextFalseTest() {
        boolean actualResult = restaurantValidator.isValidHouse(longText);
        assertFalse(actualResult);
    }

    @Test
    public void isValidBlockTest() {
        boolean actualResult = restaurantValidator.isValidBlock(mapData);
        assertTrue(actualResult);
    }

    @Test
    public void isValidBlockZeroTest() {
        mapData.put(BLOCK, zero);
        boolean actualResult = restaurantValidator.isValidBlock(mapData);
        assertTrue(actualResult);
    }

    @Test
    public void isValidBlockEmptyStringTest() {
        mapData.put(BLOCK, emptyString);
        boolean actualResult = restaurantValidator.isValidBlock(mapData);
        assertTrue(actualResult);
    }

    @Test
    public void isValidBlockNotNumberFalseTest() {
        mapData.put(BLOCK, incorrectNumber);
        boolean actualResult = restaurantValidator.isValidBlock(mapData);
        assertFalse(actualResult);
    }

    @Test
    public void isValidBlockNegativeNumberFalseTest() {
        mapData.put(BLOCK, negativeNumber);
        boolean actualResult = restaurantValidator.isValidBlock(mapData);
        assertFalse(actualResult);
    }

    @Test
    public void isValidNewBlockTest() {
        boolean actualResult = restaurantValidator.isValidNewBlock(number);
        assertTrue(actualResult);
    }

    @Test
    public void isValidNewBlockZeroTest() {
        boolean actualResult = restaurantValidator.isValidNewBlock(zero);
        assertTrue(actualResult);
    }

    @Test
    public void isValidNewBlockEmptyStringTest() {
        boolean actualResult = restaurantValidator.isValidNewBlock(emptyString);
        assertTrue(actualResult);
    }

    @Test
    public void isValidNewBlockNotNumberFalseTest() {
        boolean actualResult = restaurantValidator.isValidNewBlock(incorrectNumber);
        assertFalse(actualResult);
    }

    @Test
    public void isValidNewBlockNegativeNumberFalseTest() {
        boolean actualResult = restaurantValidator.isValidNewBlock(negativeNumber);
        assertFalse(actualResult);
    }
}
