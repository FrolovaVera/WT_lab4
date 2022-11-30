package by.epam.burgershop.controller.command.impl.customer;

import by.epam.burgershop.controller.command.Command;
import by.epam.burgershop.controller.command.CommandResult;
import by.epam.burgershop.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Go to restaurant for customer page command.
 */
public class GoToRestaurantForCustomerPageCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        return new CommandResult(PagePath.RESTAURANTS_FOR_CUSTOMER, CommandResult.RoutingType.REDIRECT);
    }
}
