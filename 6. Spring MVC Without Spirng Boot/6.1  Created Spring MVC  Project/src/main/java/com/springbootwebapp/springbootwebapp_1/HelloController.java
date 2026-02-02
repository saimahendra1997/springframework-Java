package com.springbootwebapp.springbootwebapp_1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String homePage() {
//        return "index.jsp";
        return "index"; // removing .jsp extension and moving the view pages to views directory
    }

    @RequestMapping("add")
    public ModelAndView resultPage(@RequestParam("num1") long val1, @RequestParam("num2") long val2, ModelAndView modelAndView) {;
        try {
            modelAndView.addObject("num1", val1);
            modelAndView.addObject("num2", val2);
            long result = val1 + val2;
            modelAndView.addObject("result", result);
            modelAndView.addObject("operation", "Addition");
            modelAndView.addObject("error", null);  // Clear any previous error
            modelAndView.setViewName("result");
        } catch (Exception e) {
        modelAndView.addObject("error", "Invalid input: " + e.getMessage());
        }
        return modelAndView;
    }

    // Subtraction mapping
    @RequestMapping("subtract")
    public ModelAndView subtract(@RequestParam("num1") long val1, @RequestParam("num2") long val2, ModelAndView modelAndView) {
        try {
            modelAndView.addObject("num1", val1);
            modelAndView.addObject("num2", val2);
            long result = val1 - val2;
            modelAndView.addObject("result", result);
            modelAndView.addObject("operation", "Subtraction");
            modelAndView.addObject("error", null);  // Clear any previous error
            modelAndView.setViewName("result");
        } catch (Exception e) {
            modelAndView.addObject("error", "Invalid input: " + e.getMessage());
        }
        return modelAndView;
    }

    // Multiplication mapping
    @RequestMapping("multiply")
    public ModelAndView multiply(@RequestParam("num1") long val1, @RequestParam("num2") long val2, ModelAndView modelAndView) {
        try {
            modelAndView.addObject("num1", val1);
            modelAndView.addObject("num2", val2);
            long result = val1 * val2;
            modelAndView.addObject("result", result);
            modelAndView.addObject("operation", "Multiplication");
            modelAndView.addObject("error", null);  // Clear any previous error
            modelAndView.setViewName("result");
        } catch (Exception e) {
            modelAndView.addObject("error", "Invalid input: " + e.getMessage());
        }
        return modelAndView;
    }

    // Division mapping (with error handling)
    @RequestMapping("divide")
    public ModelAndView divide(@RequestParam("num1") long val1, @RequestParam("num2") long val2, ModelAndView modelAndView) {
        try {
            modelAndView.addObject("num1", val1);
            modelAndView.addObject("num2", val2);
            if (val2 == 0) {
                modelAndView.addObject("error", "Division by zero is not allowed.");
                modelAndView.addObject("result", null);
            } else {
                double result = (double) val1 / val2;
                modelAndView.addObject("result", result);
                modelAndView.addObject("operation", "Division");
                modelAndView.addObject("error", null);  // Clear any previous error
            }
            modelAndView.setViewName("result");
        } catch (Exception e) {
            modelAndView.addObject("error", "Invalid input: " + e.getMessage());
        }
        return modelAndView;
    }

    // New mapping for alien form
    @RequestMapping("/alien")
    public String alienHomePage() {
        return "alienindex";  // Alien form
    }

    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute Alien alien) {
        return "alienresult";
        // For viewing JSP Calculator - http://localhost:8080/
        // For viewing Alien Homepage - Navigate to - http://localhost:8080/alien
    }

    @ModelAttribute("course")
    public String courseName()
    {
        return "Java...";
    }
}
