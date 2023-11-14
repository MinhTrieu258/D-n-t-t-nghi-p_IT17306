package poly.dn.huyndai.RestController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.dn.huyndai.Entity.Car;
import poly.dn.huyndai.Service.CarService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/cars")
public class CarRestController {
    
    @Autowired
    CarService carService;

    @GetMapping()
    public List<Car> getAllCar(){
        return carService.findAll();
    }
     
    @GetMapping("{id}")
    public Car  getCarOne(@PathVariable("id") Integer id){
        return carService.findById(id).get();

    }
@PostMapping
  public Car newTodo(@RequestBody Car car) {
	  return carService.create(car);
  }
   @PutMapping("{id}")
   public Car updateTodo(@PathVariable("id") Integer id, @RequestBody Car car){
	   return carService.update(car);
   }
   
   @DeleteMapping("{id}")
   public void delete(@PathVariable("id") Integer id) {
       carService.deleteById(id);
   }
}
