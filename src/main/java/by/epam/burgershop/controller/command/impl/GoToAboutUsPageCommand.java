package by.epam.burgershop.controller.command.impl;

import by.epam.burgershop.controller.command.Command;
import by.epam.burgershop.controller.command.CommandResult;
import by.epam.burgershop.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Go to about us page command.
 */
public class GoToAboutUsPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        return new CommandResult(PagePath.ABOUT_US, CommandResult.RoutingType.REDIRECT);
    }
}
