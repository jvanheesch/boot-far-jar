package com.github.jvanheesch.fat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class Filter1 implements Filter {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * The issue is the following:
     * The call to http://localhost:8080/someServlet works fine (try curl and see logs).
     * The browser, however, also sends a favicon request.
     * This request is handled by DispatcherServlet, after this filter writes a partial response, which leads to the exception.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Filter1 - start.");
        response.getWriter().write("Filter1 - start. \n");
        chain.doFilter(request, response);
        response.getWriter().write("Filter1 - end. \n");
        LOGGER.info("Filter1 - end.");
    }
}
