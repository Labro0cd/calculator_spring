package com.example.calculatorspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final ServiceCalculator serviceCalculator;

    public CalculatorController(ServiceCalculator serviceCalculator) {
        this.serviceCalculator = serviceCalculator;
    }

    @GetMapping(path = "/calculator")
    public String helloCalculator(){
        return "Добро пожаловать в калькулятор";
    }
    @GetMapping(path = "/calculator/plus")
    public String plusNumber(@RequestParam("num1") int num1,@RequestParam("num2") int num2){
        return num1 + " + " + num2 + " = " + serviceCalculator.plus(num1,num2);
    }
    @GetMapping(path = "/calculator/minus")
    public String  minusNumber(@RequestParam("num1") int num1,@RequestParam("num2") int num2){
        return num1 + " - " + num2 + " = " + serviceCalculator.minus(num1,num2);
    }
    @GetMapping(path = "/calculator/multiply")
    public String multiplyNumber(@RequestParam("num1") int num1,@RequestParam("num2") int num2){
        return num1 + " * " + num2 + " = " + serviceCalculator.multiply(num1,num2);
    }
    @GetMapping(path = "/calculator/divide")
    public String divideNumber(@RequestParam("num1") int num1,@RequestParam("num2") int num2){
        return num1 + " / " + num2 + " = " + serviceCalculator.divide(num1,num2);
    }

}
