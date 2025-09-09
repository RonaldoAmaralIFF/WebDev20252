package br.edu.iff.ccc.webdev.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice(annotations = Controller.class)
public class ViewGlobalAdviceException {

   @ExceptionHandler(RuntimeException.class)
   public ModelAndView defaltErrorHandler(HttpServletRequest req, Exception e) {
       ModelAndView mav = new ModelAndView();
       mav.addObject("error", e.getClass().getSimpleName());
       mav.addObject("message", e.getMessage());
       mav.addObject("path", req.getRequestURL());
       mav.addObject("status", 500);
       mav.setViewName("error");
       System.out.println("Exceção capturada no GlobalAdvice: " + e.getMessage() + " - URL: " + req.getRequestURL());
       return mav;
   }

}
