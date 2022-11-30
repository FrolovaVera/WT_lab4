package by.epam.burgershop.controller.command.impl.admin;

import by.epam.burgershop.controller.command.Command;
import by.epam.burgershop.controller.command.CommandResult;
import by.epam.burgershop.controller.command.PagePath;
import by.epam.burgershop.controller.command.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The type Go to main admin page command.
 */
public class GoToMainAdminPageCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.CURRENT_PAGE, 1);
        return new CommandResult(PagePath.MAIN_ADMIN, CommandResult.RoutingType.REDIRECT);
    }
}
