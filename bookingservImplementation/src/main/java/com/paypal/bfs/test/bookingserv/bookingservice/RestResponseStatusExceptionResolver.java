package com.paypal.bfs.test.bookingserv.bookingservice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RestResponseStatusExceptionResolver extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            if (ex instanceof DataIntegrityViolationException) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                response.sendError(HttpServletResponse.SC_CONFLICT, "Duplicate Booking.");

            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}