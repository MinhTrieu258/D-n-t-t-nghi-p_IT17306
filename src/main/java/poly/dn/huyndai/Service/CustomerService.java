package poly.dn.huyndai.Service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.core.userdetails.UserDetails;
import poly.dn.huyndai.Entity.Customer;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface CustomerService {
    long count();

    <S extends Customer> long count(Example<S> example);

    void delete(Customer entity);

    void deleteAll();

    void deleteAll(Iterable<? extends Customer> entities);

    void deleteAllById(Iterable<? extends String> ids);

    void deleteAllByIdInBatch(Iterable<String> ids);

    void deleteAllInBatch();

    void deleteAllInBatch(Iterable<Customer> entities);

    List<Customer> findByNameContaining(String name);

    void deleteById(String id);

    void deleteInBatch(Iterable<Customer> entities);

    <S extends Customer> boolean exists(Example<S> example);

    boolean existsById(String id);

    <S extends Customer> List<S> findAll(Example<S> example);

    <S extends Customer> List<S> findAll(Example<S> example, Sort sort);

    List<Customer> findAll();

    List<Customer> findAll(Sort sort);

    Page<Customer> findAll(Pageable pageable);

    <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable);

    List<Customer> findAllById(Iterable<String> ids);

    <S extends Customer, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    Optional<Customer> findById(String id);

    <S extends Customer> Optional<S> findOne(Example<S> example);

    void flush();

    Customer getById(String arg0);

    Customer getOne(String arg0);

    Customer getReferenceById(String id);

    <S extends Customer> S save(S entity);

    <S extends Customer> List<S> saveAll(Iterable<S> entities);

    <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities);

    <S extends Customer> S saveAndFlush(S entity);

    List<Customer> getAdminOrStaff();

    void saveUser(UserDetails user);

    Customer findByEmail(String email);
}
