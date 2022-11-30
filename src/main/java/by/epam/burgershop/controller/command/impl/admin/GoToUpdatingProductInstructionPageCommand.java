package by.epam.burgershop.controller.command.impl.admin;

import by.epam.burgershop.controller.command.*;
import by.epam.burgershop.dto.ProductDto;
import by.epam.burgershop.exception.ServiceException;
import by.epam.burgershop.model.service.ProductService;
import by.epam.burgershop.model.service.impl.ProductServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The type Go to updating product instruction page command.
 */
public class GoToUpdatingProductInstructionPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String productId = request.getParameter(RequestParameter.PRODUCT_ID);
        long id = Long.parseLong(productId);
        session.setAttribute(SessionAttribute.PRODUCT_ID, id);
        ProductService productService = ProductServiceImpl.getInstance();
        ProductDto product;
        try {
            product = productService.findInstructionByProductId(id);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "ServiceException while find ProductDto by productId ", e);
            return new CommandResult(PagePath.ERROR_500_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        session.setAttribute(SessionAttribute.PRODUCT, product);
        return new CommandResult(PagePath.UPDATING_PRODUCT_INSTRUCTION, CommandResult.RoutingType.REDIRECT);
    }
}
