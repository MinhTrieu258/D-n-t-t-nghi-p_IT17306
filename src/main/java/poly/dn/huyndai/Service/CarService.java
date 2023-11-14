package poly.dn.huyndai.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.dn.huyndai.Entity.Car;

public interface CarService {

    <S extends Car> S save(S entity);

    <S extends Car> List<S> saveAll(Iterable<S> entities);

    <S extends Car> Optional<S> findOne(Example<S> example);

    List<Car> findAll(Sort sort);

    void flush();

    Page<Car> findAll(Pageable pageable);

    <S extends Car> S saveAndFlush(S entity);

    <S extends Car> List<S> saveAllAndFlush(Iterable<S> entities);

    List<Car> findAll();

    List<Car> findAllById(Iterable<Integer> ids);

    void deleteInBatch(Iterable<Car> entities);

    <S extends Car> Page<S> findAll(Example<S> example, Pageable pageable);

    Optional<Car> findById(Integer id);

    void deleteAllInBatch(Iterable<Car> entities);

    boolean existsById(Integer id);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    <S extends Car> long count(Example<S> example);

    <S extends Car> boolean exists(Example<S> example);

    void deleteAllInBatch();

    Car getOne(Integer id);

    <S extends Car, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    long count();

    void deleteById(Integer id);

    Car getById(Integer id);

    void delete(Car entity);

    Car getReferenceById(Integer id);

    void deleteAllById(Iterable<? extends Integer> ids);

    void deleteAll(Iterable<? extends Car> entities);

    <S extends Car> List<S> findAll(Example<S> example);

    <S extends Car> List<S> findAll(Example<S> example, Sort sort);

    void deleteAll();
	Car create(Car car);
    Car update(Car car);
    List<Car> findByCategoryId(String id);
    List<Car> findByNameContaining(String name);
    List<Car> findByPriceBetween(double minPrice, double maxPrice );
	Page<Car> findByNameContaining(String name, Pageable pageable);
}