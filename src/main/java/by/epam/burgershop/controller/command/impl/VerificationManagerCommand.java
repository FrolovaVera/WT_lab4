package by.epam.burgershop.controller.command.impl;

import by.epam.burgershop.controller.command.*;
import by.epam.burgershop.entity.Status;
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
 * The type Verification manager command.
 */
public class VerificationManagerCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserService userService = UserServiceImpl.getInstance();
        String id = request.getParameter(RequestParameter.USER_ID);
        List<User> managers;
        try {
            userService.updatemanagerStatus(id, Status.ACTIVE);
            managers = userService.findAllmanagers();
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Exception in method execute while update user status or find all managers ", e);
            return new CommandResult(PagePath.ERROR_500_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        session.setAttribute(SessionAttribute.ALL_MANAGERS, managers);
        return new CommandResult(PagePath.ALL_MANAGERS, CommandResult.RoutingType.REDIRECT);
    }
}