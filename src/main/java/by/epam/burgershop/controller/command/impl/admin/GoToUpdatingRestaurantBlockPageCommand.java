package by.epam.burgershop.controller.command.impl.admin;

import by.epam.burgershop.controller.command.*;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Go to updating restaurant block page command.
 */
public class GoToUpdatingRestaurantBlockPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        String id = request.getParameter(RequestParameter.RESTAURANT_ID);
        long restaurantId = Long.parseLong(id);
        request.getSession().setAttribute(SessionAttribute.PHARMACY_ID, restaurantId);
        return new CommandResult(PagePath.UPDATING_RESTAURANT_BLOCK, CommandResult.RoutingType.REDIRECT);
    }
}
