package poly.dn.huyndai.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.dn.huyndai.Entity.OrderDetail;

public interface OrderDetailService {

    long count();

    <S extends OrderDetail> long count(Example<S> example);

    void delete(OrderDetail entity);

    void deleteAll();

    void deleteAll(Iterable<? extends OrderDetail> entities);

    void deleteAllById(Iterable<? extends Long> ids);

    void deleteAllByIdInBatch(Iterable<Long> ids);

    void deleteAllInBatch();

    void deleteAllInBatch(Iterable<OrderDetail> entities);

    void deleteById(Long id);

    void deleteInBatch(Iterable<OrderDetail> entities);

    <S extends OrderDetail> boolean exists(Example<S> example);

    boolean existsById(Long id);

    <S extends OrderDetail> List<S> findAll(Example<S> example);

    <S extends OrderDetail> List<S> findAll(Example<S> example, Sort sort);

    List<OrderDetail> findAll();

    List<OrderDetail> findAll(Sort sort);

    Page<OrderDetail> findAll(Pageable pageable);

    <S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable);

    List<OrderDetail> findAllById(Iterable<Long> ids);

    <S extends OrderDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    Optional<OrderDetail> findById(Long id);

    <S extends OrderDetail> Optional<S> findOne(Example<S> example);

    void flush();

    OrderDetail getById(Long arg0);

    OrderDetail getOne(Long arg0);

    OrderDetail getReferenceById(Long id);

    <S extends OrderDetail> S save(S entity);

    <S extends OrderDetail> List<S> saveAll(Iterable<S> entities);

    <S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities);

    <S extends OrderDetail> S saveAndFlush(S entity);

}