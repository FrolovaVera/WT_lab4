package by.epam.burgershop.controller.command.impl.admin;

import by.epam.burgershop.controller.command.*;

import by.epam.burgershop.dto.RestaurantDto;
import by.epam.burgershop.exception.ServiceException;
import by.epam.burgershop.model.service.RestaurantService;
import by.epam.burgershop.model.service.impl.RestaurantServiceImpl;
import by.epam.burgershop.model.validation.RestaurantValidator;
import by.epam.burgershop.model.validation.impl.RestaurantValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Updating restaurant street command.
 */
public class UpdatingRestaurantStreetCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final int RECORD_PER_PAGE = 15;

    @Override
    public CommandResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int currentPage = (int)session.getAttribute(SessionAttribute.CURRENT_PAGE);
        String newStreet = request.getParameter(RequestParameter.UPDATING_RESTAURANT_STREET);
        long id = (long) session.getAttribute(SessionAttribute.PHARMACY_ID);
        RestaurantService restaurantService = RestaurantServiceImpl.getInstance();
        RestaurantValidator restaurantValidator = RestaurantValidatorImpl.getInstance();
        List<RestaurantDto> currentRestaurants;
        List<RestaurantDto> nextRestaurants;
        List<RestaurantDto> previousRestaurants = new ArrayList<>();

        if (!restaurantValidator.isValidCityOrStreet(newStreet)) {
            request.setAttribute(RequestAttribute.UPDATING_RESTAURANT_STREET_ERROR, BundleKey.PHARMACY_STRING_PARAMETERS_ERROR);
            return new CommandResult(PagePath.UPDATING_RESTAURANT_STREET, CommandResult.RoutingType.FORWARD);
        }

        try {
            restaurantService.updateStreet(id, newStreet);
            if (currentPage != 1) {
                previousRestaurants = restaurantService.findListRestaurants((currentPage - 2) * RECORD_PER_PAGE);
            }
            currentRestaurants = restaurantService.findListRestaurants((currentPage - 1) * RECORD_PER_PAGE);
            nextRestaurants = restaurantService.findListRestaurants((currentPage) * RECORD_PER_PAGE);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "ServiceException in method execute while update street or find all current pharmacies ", e);
            return new CommandResult(PagePath.ERROR_500_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        session.setAttribute(SessionAttribute.PREVIOUS_RESTAURANTS, previousRestaurants);
        session.setAttribute(SessionAttribute.NEXT_RESTAURANTS, nextRestaurants);
        session.setAttribute(SessionAttribute.CURRENT_PHARMACIES, currentRestaurants);
        return new CommandResult(PagePath.ALL_RESTAURANTS, CommandResult.RoutingType.REDIRECT);
    }
}
