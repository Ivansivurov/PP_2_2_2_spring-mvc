package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class CarServiceImpl{

    public static List<Car> getCars(List<Car> carList, int count) {
        if (count == 0 || count > 5) return carList;
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}

