package by.epam.burgershop.controller.command.impl.customer;

import by.epam.burgershop.controller.command.Command;
import by.epam.burgershop.controller.command.CommandResult;
import by.epam.burgershop.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Go to customer main page command.
 */
public class GoToCustomerMainPageCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        return new CommandResult(PagePath.MAIN_CUSTOMER, CommandResult.RoutingType.REDIRECT);
    }
}
