package by.epam.burgershop.controller.command.impl.customer;

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
 * The type Go to about product page command.
 */
public class GoToAboutProductPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public CommandResult execute(HttpServletRequest request) {
        String id = request.getParameter(RequestParameter.PRODUCT_ID);
        long productId = Long.parseLong(id);
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.PRODUCT_ID, productId);
        ProductService productService = ProductServiceImpl.getInstance();
        ProductDto productDto;
        try {
            productDto = productService.findProductById(id);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Exception in method execute while find product by id ", e);
            return new CommandResult(PagePath.ERROR_500_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        session.setAttribute(SessionAttribute.PRODUCT, productDto);
        return new CommandResult(PagePath.ABOUT_PRODUCT, CommandResult.RoutingType.REDIRECT);

    }
}
