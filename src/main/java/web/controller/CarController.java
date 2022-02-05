package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.config.WebConfig;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping()
    public String carsPage(@RequestParam(value = "count", defaultValue = "5") int carsCount, Model model) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("bmw", 5, "black"));
        carList.add(new Car("kamaz", 10, "green"));
        carList.add(new Car("volga", 1, "white"));
        carList.add(new Car("lada", 9, "baklajan"));
        carList.add(new Car("matiz", 3, "yellow"));
        carList = carService.getCars(carList, carsCount);
        model.addAttribute("carList", carList);
        return "cars";
    }


}
