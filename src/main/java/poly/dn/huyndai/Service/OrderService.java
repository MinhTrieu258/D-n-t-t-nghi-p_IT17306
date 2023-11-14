package poly.dn.huyndai.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.dn.huyndai.Entity.Order;

public interface OrderService {
	List<Order> searhByAmount(Double min);
    long count();

    <S extends Order> long count(Example<S> example);

    void delete(Order entity);

    void deleteAll();

    void deleteAll(Iterable<? extends Order> entities);

    void deleteAllById(Iterable<? extends Long> ids);

    void deleteAllByIdInBatch(Iterable<Long> ids);

    void deleteAllInBatch();

    void deleteAllInBatch(Iterable<Order> entities);

    void deleteById(Long id);

    void deleteInBatch(Iterable<Order> entities);

    <S extends Order> boolean exists(Example<S> example);

    boolean existsById(Long id);

    <S extends Order> List<S> findAll(Example<S> example);

    <S extends Order> List<S> findAll(Example<S> example, Sort sort);

    List<Order> findAll();

    List<Order> findAll(Sort sort);

    Page<Order> findAll(Pageable pageable);

    <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable);

    List<Order> findAllById(Iterable<Long> ids);

    <S extends Order, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    Optional<Order> findById(Long id);

    <S extends Order> Optional<S> findOne(Example<S> example);

    void flush();

    Order getById(Long arg0);

    Order getOne(Long arg0);

    Order getReferenceById(Long id);

    <S extends Order> S save(S entity);

    <S extends Order> List<S> saveAll(Iterable<S> entities);

    <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities);

    <S extends Order> S saveAndFlush(S entity);

}