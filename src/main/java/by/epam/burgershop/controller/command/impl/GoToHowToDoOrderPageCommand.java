package by.epam.burgershop.controller.command.impl;

import by.epam.burgershop.controller.command.Command;
import by.epam.burgershop.controller.command.CommandResult;
import by.epam.burgershop.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Go to how to do order page command.
 */
public class GoToHowToDoOrderPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        return new CommandResult(PagePath.HOW_TO_DO_ORDER, CommandResult.RoutingType.REDIRECT);
    }
}
