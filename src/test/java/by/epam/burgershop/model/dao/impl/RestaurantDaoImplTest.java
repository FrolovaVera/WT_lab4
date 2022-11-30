package by.epam.burgershop.model.dao.impl;

import by.epam.burgershop.entity.Restaurant;
import by.epam.burgershop.exception.DaoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestaurantDaoImplTest {

        @Mock
        private RestaurantDaoImpl restaurantDao;
        private List<Restaurant> restaurants;
        private List<Restaurant> testRestaurants;
        private Restaurant testRestaurant;
        private Restaurant restaurant;

        @BeforeEach
        public void setUp() {
            restaurants = new ArrayList<>();
            testRestaurants = new ArrayList<>();
            testRestaurant = new Restaurant.Builder()
                    .setRestaurantId(1)
                    .setNumber(13)
                    .setCity("Minsk")
                    .setStreet("Ukrainki")
                    .setHouse("22A")
                    .setBlock(0)
                    .build();
            restaurant = new Restaurant.Builder()
                    .setRestaurantId(2)
                    .setNumber(14)
                    .setCity("Minsk")
                    .setStreet("Pushkina")
                    .setHouse("21")
                    .setBlock(0)
                    .build();
            restaurants.add(restaurant);
            restaurants.add(testRestaurant);

        }

        @Test
        public void findListRestaurantsTest() throws DaoException {
            when(restaurantDao.findRestaurants(1)).thenReturn(restaurants);
            List<Restaurant> actualRestaurants = restaurantDao.findRestaurants(1);
            assertEquals(restaurants, actualRestaurants);
        }

        @Test
        public void findListRestaurantsFalseTest() throws DaoException {
            when(restaurantDao.findRestaurants(1)).thenReturn(restaurants);
            List<Restaurant> actualRestaurants = restaurantDao.findRestaurants(1);
            assertNotEquals(testRestaurants, actualRestaurants);
        }

        @Test
        public void findRestaurantsByCityTest() throws DaoException {
            when(restaurantDao.findRestaurantsByCity("Minsk")).thenReturn(restaurants);
            List<Restaurant> actualRestaurants = restaurantDao.findRestaurantsByCity("Minsk");
            assertEquals(restaurants, actualRestaurants);
        }

        @Test
        public void findRestaurantsByCityFalseTest() throws DaoException {
            when(restaurantDao.findRestaurantsByCity("Minsk")).thenReturn(restaurants);
            List<Restaurant> actualRestaurants = restaurantDao.findRestaurantsByCity("Minsk");
            assertNotEquals(testRestaurants, actualRestaurants);
        }


        @Test
        public void findRestaurantsNumberTest() throws DaoException {
            when(restaurantDao.findRestaurantsNumber()).thenReturn(2);
            int result = restaurantDao.findRestaurantsNumber();
            assertEquals(2, result);
        }

        @Test
        public void findRestaurantsNumberFalseTest() throws DaoException {
            when(restaurantDao.findRestaurantsNumber()).thenReturn(2);
            int result = restaurantDao.findRestaurantsNumber();
            assertNotEquals(0, result);
        }

        @Test
        public void findRestaurantByIdTest() throws DaoException {
            when(restaurantDao.findRestaurantById(1)).thenReturn(Optional.of(testRestaurant));
            Optional<Restaurant> restaurant = restaurantDao.findRestaurantById(1);
            assertEquals(testRestaurant, restaurant.get());
        }

        @Test
        public void findRestaurantByIdFalseTest() throws DaoException {
            when(restaurantDao.findRestaurantById(1)).thenReturn(Optional.of(testRestaurant));
            Optional<Restaurant> actualRestaurant = restaurantDao.findRestaurantById(1);
            assertNotEquals(restaurant, actualRestaurant.get());
        }


}
