package com.example.demo.web.controller;

import com.example.demo.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @Autowired
    private Car car;

    @RequestMapping("/car")
    public void car() {
        Car car1 = new Car();
        car.run();
        car1.run();
    }

}
