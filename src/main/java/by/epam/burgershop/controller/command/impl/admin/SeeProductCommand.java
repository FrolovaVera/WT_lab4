package by.epam.burgershop.controller.command.impl.admin;

import by.epam.burgershop.controller.command.Command;
import by.epam.burgershop.controller.command.CommandResult;
import by.epam.burgershop.controller.command.PagePath;
import by.epam.burgershop.controller.command.SessionAttribute;
import by.epam.burgershop.dto.ProductDto;
import by.epam.burgershop.exception.ServiceException;
import by.epam.burgershop.model.service.ProductService;
import by.epam.burgershop.model.service.impl.ProductServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The type See product command.
 */
public class SeeProductCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request) {
        ProductService productService = ProductServiceImpl.getInstance();
        long id = (long) request.getSession().getAttribute(SessionAttribute.PRODUCT_ID);
        String productId = String.valueOf(id);
        ProductDto product;

        try {
            product = productService.findProductById(productId);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "ServiceException in method execute while find product by id ", e);
            return new CommandResult(PagePath.ERROR_500_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        request.getSession().setAttribute(SessionAttribute.PRODUCT, product);
        return new CommandResult(PagePath.SEE_PRODUCT, CommandResult.RoutingType.REDIRECT);
    }
}
