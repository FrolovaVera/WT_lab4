package by.epam.burgershop.controller.command.impl.manager;

import by.epam.burgershop.controller.command.*;
import by.epam.burgershop.entity.Order;
import by.epam.burgershop.exception.ServiceException;
import by.epam.burgershop.model.service.OrderService;
import by.epam.burgershop.model.service.impl.OrderServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The type Updating order status to deleted command.
 */
public class UpdatingOrderStatusToDeletedCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String orderStatusId = request.getParameter(RequestParameter.ORDER_STATUS_ID);
        String orderId = request.getParameter(RequestParameter.ORDER_ID);
        OrderService orderService = OrderServiceImpl.getInstance();
        Order order;
        try {
            order = orderService.updateStatusOrder(orderStatusId, orderId, null);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "ServiceException in method execute while update order status", e);
            return new CommandResult(PagePath.ERROR_500_PAGE, CommandResult.RoutingType.FORWARD);
        }
        session.setAttribute(SessionAttribute.ORDER, order);
        return new CommandResult(PagePath.BASKET_FOR_ORDER, CommandResult.RoutingType.REDIRECT);
    }
}
