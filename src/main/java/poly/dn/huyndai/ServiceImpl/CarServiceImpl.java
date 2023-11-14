package poly.dn.huyndai.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import poly.dn.huyndai.Entity.Car;
import poly.dn.huyndai.Repository.CarRepository;
import poly.dn.huyndai.Service.CarService;



@Service
public class CarServiceImpl implements CarService  {
    
    private final  CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @Override
    public  List<Car> findByPriceBetween(double minPrice, double maxPrice ) {
        return carRepository.findByPriceBetween(minPrice, maxPrice);
    }



    
    @Override
	public Page<Car> findByNameContaining(String name, Pageable pageable) {
		return carRepository.findByNameContaining(name, pageable);
	}
	@Override
	public List<Car> findByNameContaining(String name) {
		return carRepository.findByNameContaining(name);
	}
    @Override
    public List<Car> findByCategoryId(String cid) {
        return carRepository.findByCategoryId(cid);
    }
    @Override
    public <S extends Car> S save(S entity) {
        return carRepository.save(entity);
    }

    @Override
    public <S extends Car> List<S> saveAll(Iterable<S> entities) {
        return carRepository.saveAll(entities);
    }

    @Override
    public <S extends Car> Optional<S> findOne(Example<S> example) {
        return carRepository.findOne(example);
    }

    @Override
    public List<Car> findAll(Sort sort) {
        return carRepository.findAll(sort);
    }

    @Override
    public void flush() {
        carRepository.flush();
    }

    @Override
    public Page<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @Override
    public <S extends Car> S saveAndFlush(S entity) {
        return carRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Car> List<S> saveAllAndFlush(Iterable<S> entities) {
        return carRepository.saveAllAndFlush(entities);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findAllById(Iterable<Integer> ids) {
        return carRepository.findAllById(ids);
    }

    @Override
    public void deleteInBatch(Iterable<Car> entities) {
        carRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends Car> Page<S> findAll(Example<S> example, Pageable pageable) {
        return carRepository.findAll(example, pageable);
    }

    @Override
    public Optional<Car> findById(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public void deleteAllInBatch(Iterable<Car> entities) {
        carRepository.deleteAllInBatch(entities);
    }

    @Override
    public boolean existsById(Integer id) {
        return carRepository.existsById(id);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        carRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public <S extends Car> long count(Example<S> example) {
        return carRepository.count(example);
    }

    @Override
    public <S extends Car> boolean exists(Example<S> example) {
        return carRepository.exists(example);
    }

    @Override
    public void deleteAllInBatch() {
        carRepository.deleteAllInBatch();
    }

    @Override
    public Car getOne(Integer id) {
        return carRepository.getOne(id);
    }

    @Override
    public <S extends Car, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return carRepository.findBy(example, queryFunction);
    }

    @Override
    public long count() {
        return carRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car getById(Integer id) {
        return carRepository.getById(id);
    }

    @Override
    public void delete(Car entity) {
        carRepository.delete(entity);
    }

    @Override
    public Car getReferenceById(Integer id) {
        return carRepository.getReferenceById(id);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        carRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends Car> entities) {
        carRepository.deleteAll(entities);
    }

    @Override
    public <S extends Car> List<S> findAll(Example<S> example) {
        return carRepository.findAll(example);
    }

    @Override
    public <S extends Car> List<S> findAll(Example<S> example, Sort sort) {
        return carRepository.findAll(example, sort);
    }

    @Override
    public void deleteAll() {
        carRepository.deleteAll();
    }

    @Override
public Car create(Car car) {
	// TODO Auto-generated method stub
	return carRepository.save(car);
}

@Override
public Car update(Car car) {
	// TODO Auto-generated method stub
	return carRepository.save(car);
}

    
}
