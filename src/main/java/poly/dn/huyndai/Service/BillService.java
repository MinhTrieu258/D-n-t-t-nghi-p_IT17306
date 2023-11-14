package poly.dn.huyndai.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.dn.huyndai.Entity.Bill;

public interface BillService {

    long count();

    <S extends Bill> long count(Example<S> example);

    void delete(Bill entity);

    void deleteAll();

    void deleteAll(Iterable<? extends Bill> entities);

    void deleteAllById(Iterable<? extends Long> ids);

    void deleteAllByIdInBatch(Iterable<Long> ids);

    void deleteAllInBatch();

    void deleteAllInBatch(Iterable<Bill> entities);

    void deleteById(Long id);

    void deleteInBatch(Iterable<Bill> entities);

    <S extends Bill> boolean exists(Example<S> example);

    boolean existsById(Long id);

    <S extends Bill> List<S> findAll(Example<S> example);

    <S extends Bill> List<S> findAll(Example<S> example, Sort sort);

    List<Bill> findAll();

    List<Bill> findAll(Sort sort);

    Page<Bill> findAll(Pageable pageable);

    <S extends Bill> Page<S> findAll(Example<S> example, Pageable pageable);

    List<Bill> findAllById(Iterable<Long> ids);

    <S extends Bill, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    Optional<Bill> findById(Long id);

    <S extends Bill> Optional<S> findOne(Example<S> example);

    void flush();

    Bill getById(Long arg0);

    Bill getOne(Long arg0);

    Bill getReferenceById(Long id);

    <S extends Bill> S save(S entity);

    <S extends Bill> List<S> saveAll(Iterable<S> entities);

    <S extends Bill> List<S> saveAllAndFlush(Iterable<S> entities);

    <S extends Bill> S saveAndFlush(S entity);

}