package by.epam.burgershop.controller.command.impl.admin;

import by.epam.burgershop.controller.command.*;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Go to updating product name page command.
 */
public class GoToUpdatingProductNamePageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        String productId = request.getParameter(RequestParameter.PRODUCT_ID);
        long id = Long.parseLong(productId);
        request.getSession().setAttribute(SessionAttribute.PRODUCT_ID, id);
        return new CommandResult(PagePath.UPDATING_PRODUCT_NAME, CommandResult.RoutingType.REDIRECT);
    }
}
