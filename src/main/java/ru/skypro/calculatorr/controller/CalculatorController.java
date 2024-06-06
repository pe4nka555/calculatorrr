package ru.skypro.calculatorr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.calculatorr.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings(){
        return "Добро пожаловать в калькулятор";
    }


    @GetMapping("/sum")
    public String sum(@RequestParam Integer a, @RequestParam Integer b) {
        return a + " + " + b + " = " + calculatorService.sum(a, b);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam Integer a, @RequestParam Integer b) {
        return a + " - " + b + " = " + calculatorService.minus(a, b);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam Integer a, @RequestParam Integer b) {
        return a + " * " + b + " = " + calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        if (b == 0) {
            return "Деление на ноль запрещено";
        }
        return a + " / " + b + " = " + calculatorService.divide(a, b);
    }

}
