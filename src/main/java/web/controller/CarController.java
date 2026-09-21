package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;


@Controller //create a new controller with annotation
public class CarController {
    //Step 3: Connect Service to Controller (Dependency Injection)
    //Inject the CarService interface into CarController using constructor injection.
    private final CarService carService;

    @Autowired

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count",required = false)Integer count, Model model){
        model.addAttribute("cars",carService.getCars(count));
        return "cars";
}

}
