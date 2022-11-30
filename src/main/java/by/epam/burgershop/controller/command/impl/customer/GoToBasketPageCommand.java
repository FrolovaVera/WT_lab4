package by.epam.burgershop.controller.command.impl.customer;

import by.epam.burgershop.controller.command.Command;
import by.epam.burgershop.controller.command.CommandResult;
import by.epam.burgershop.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Go to basket page command.
 */
public class GoToBasketPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        return new CommandResult(PagePath.BASKET, CommandResult.RoutingType.REDIRECT);
    }
}
