package by.epam.burgershop.controller.command.impl.admin;

import by.epam.burgershop.controller.command.Command;
import by.epam.burgershop.controller.command.CommandResult;
import by.epam.burgershop.controller.command.PagePath;
import by.epam.burgershop.controller.command.SessionAttribute;
import by.epam.burgershop.entity.User;
import by.epam.burgershop.exception.ServiceException;
import by.epam.burgershop.model.service.UserService;
import by.epam.burgershop.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * The type Go to inactive managers page command.
 */
public class GoToInactiveManagersPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserService userService = UserServiceImpl.getInstance();
        List<User> inactivemanagers;
        try {
            inactivemanagers = userService.findInactivemanagers();
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "ServiceException in method execute while find inactive managers ", e);
            return new CommandResult(PagePath.ERROR_500_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        session.setAttribute(SessionAttribute.INACTIVE_MANAGERS, inactivemanagers);
        return new CommandResult(PagePath.INACTIVE_MANAGERS, CommandResult.RoutingType.REDIRECT);
    }
}