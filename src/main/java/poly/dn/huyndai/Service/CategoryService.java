package poly.dn.huyndai.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.dn.huyndai.Entity.Category;

public interface CategoryService {

    <S extends Category> S save(S entity);

    <S extends Category> List<S> saveAll(Iterable<S> entities);

    <S extends Category> Optional<S> findOne(Example<S> example);

    List<Category> findAll(Sort sort);

    void flush();

    Page<Category> findAll(Pageable pageable);

    <S extends Category> S saveAndFlush(S entity);

    <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities);

    List<Category> findAll();

    List<Category> findAllById(Iterable<Integer> ids);

    void deleteInBatch(Iterable<Category> entities);

    <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);

    Optional<Category> findById(Integer id);

    void deleteAllInBatch(Iterable<Category> entities);

    boolean existsById(Integer id);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    <S extends Category> long count(Example<S> example);

    <S extends Category> boolean exists(Example<S> example);

    void deleteAllInBatch();

    Category getOne(Integer id);

    <S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    long count();

    void deleteById(Integer id);

    Category getById(Integer id);

    void delete(Category entity);

    Category getReferenceById(Integer id);

    void deleteAllById(Iterable<? extends Integer> ids);

    void deleteAll(Iterable<? extends Category> entities);

    <S extends Category> List<S> findAll(Example<S> example);

    <S extends Category> List<S> findAll(Example<S> example, Sort sort);

    void deleteAll();
    List<Category> findByNameContaining(String name);

	Page<Category> findByNameContaining(String name, Pageable pageable);
}