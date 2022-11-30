package by.epam.burgershop.model.verification;

import by.epam.burgershop.entity.User;

/**
 * The interface Email sending.
 */
public interface EmailSending {
    /**
     * Send email.
     *
     * @param user              the user
     * @param codeOrOrderNumber the code or order number
     * @param header            the header
     * @param message           the message
     */
    void sendEmail(User user, String codeOrOrderNumber, String header, String message);
}
