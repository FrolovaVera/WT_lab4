package by.epam.burgershop.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * The type Encoder filter.
 */
@WebFilter(urlPatterns = {"/*"})
public class EncoderFilter implements Filter {

    private static final String DEFAULT_ENCODING = "UTF-8";
    private String encoding;

    @Override
    public void init(FilterConfig fConfig) {
        encoding = fConfig.getInitParameter("encoding");
        if (encoding == null) {
            encoding = DEFAULT_ENCODING;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String codeRequest = servletRequest.getCharacterEncoding();

        if (!encoding.equalsIgnoreCase(codeRequest)) {
            servletRequest.setCharacterEncoding(encoding);
            servletResponse.setCharacterEncoding(encoding);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
