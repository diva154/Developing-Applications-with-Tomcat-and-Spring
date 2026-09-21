package web.service;

import org.springframework.stereotype.Service;
import web.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{
    private final List<Car> carList;
    private final CarService carService;

    public CarServiceImpl(CarService carService){
        carList = new ArrayList<>();
        carList.add(new Car("BMW",3,2021));
        carList.add(new Car("KIA",2,2013));
        carList.add(new Car("Mercedes",1,2014));
        carList.add(new Car("Audi",7,2020));
        carList.add(new Car("Fiat",4,2000));
        this.carService = carService;
    }
    @Override
    public List<Car>getCars(Integer count){
        if (count == null || count >= carList.size()){
    return carList;

        }
        if(count < 0){
            return Collections.emptyList(); //returns an empty list for negative integers
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }

}
