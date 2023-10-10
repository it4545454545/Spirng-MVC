package com.springmvc.app.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class CalculatorController {
    static Model model;

    @GetMapping("/calculator")
    public String calculator(
            @RequestParam(value = "a", required = false) Integer a,
            @RequestParam(value = "b", required = false) Integer b,
            @RequestParam(value = "action", required = false) String action,
            Model model) {
        CalculatorController.model = model;
        if ((a == null) || (b == null) || (action == null)) {
            model.addAttribute("result", "Vvedite vse parametri");
            return "first/calculator";
        }

        switch (action) {
            case "devide" -> model.addAttribute("result", devideNumbers(a, b).toString());
            case "multiply" -> model.addAttribute("result", multiplyNumbers(a, b).toString());
            case "add" -> model.addAttribute("result", addNumbers(a, b).toString());
            case "substitute" -> model.addAttribute("result", substituteNumbers(a, b).toString());
            default -> model.addAttribute("result", "WRONG ACTION");
        }

        return "first/calculator";
    }

    static public Integer addNumbers(Integer a, Integer b) {
        return a + b;
    }

    static public Integer substituteNumbers(Integer a, Integer b) {
        return a - b;
    }

    static public Integer devideNumbers(Integer a, Integer b) {
        if (b.equals(0)) {
            model.addAttribute("devideByZero", "Cant devide by zero");
            return 0;
        }
        return a / b;
    }

    static public Integer multiplyNumbers(Integer a, Integer b) {
        return a * b;
    }
}
