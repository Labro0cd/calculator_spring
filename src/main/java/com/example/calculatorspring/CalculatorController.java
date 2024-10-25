package com.example.calculatorspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final ServiceCalculator serviceCalculator;

    public CalculatorController(ServiceCalculator serviceCalculator) {
        this.serviceCalculator = serviceCalculator;
    }
    @GetMapping()
    public String calculator() {
        return "Добропожаловать в калькулятор";
    }
    @GetMapping(path = "/plus")
    public String plusNumber(@RequestParam("num1") Integer num1,@RequestParam("num2") Integer num2){
        return num1 + " + " + num2 + " = " + serviceCalculator.plus(num1,num2);
    }
    @GetMapping(path = "/minus")
    public String  minusNumber(@RequestParam("num1") Integer num1,@RequestParam("num2") Integer num2){
        return num1 + " - " + num2 + " = " + serviceCalculator.minus(num1,num2);
    }
    @GetMapping(path = "/multiply")
    public String multiplyNumber(@RequestParam("num1") Integer num1,@RequestParam("num2") Integer num2){
        return num1 + " * " + num2 + " = " + serviceCalculator.multiply(num1,num2);
    }
    @GetMapping(path = "/divide")
    public String divideNumber(@RequestParam("num1") Integer num1,@RequestParam("num2") Integer num2){
        if (num2 == 0) {
            return "На ноль делить нельзя!";
        }else {
            return num1 + " / " + num2 + " = " + serviceCalculator.divide(num1,num2);
        }
    }

}
