package by.epam.burgershop.model.validation;

/**
 * The interface Basket validator.
 */
public interface BasketValidator {
    /**
     * Is valid product quantity boolean.
     *
     * @param quantity the quantity
     * @return the boolean
     */
    boolean isValidProductQuantity(String quantity);
}
