package org.astashonok.assessmentsystem.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handlerNoHandlerFoundException() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("errorCaused", true);
        mv.addObject("errorTitle", "Страница не сконструирована!");
        mv.addObject("errorDescription", "Страница, которую вы ищете, не доступна сейчас!");
        mv.addObject("title", "404 Error Page");
        return mv;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception e) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("errorCaused", true);

        // for debugging
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);

        mv.addObject("errorTitle", "Свяжитесь с администратором");
        mv.addObject("errorDescription", stringWriter.toString());
        mv.addObject("title", "Error");
        return mv;
    }
}
