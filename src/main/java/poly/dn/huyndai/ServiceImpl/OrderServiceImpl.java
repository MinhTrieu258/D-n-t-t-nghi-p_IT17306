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

import poly.dn.huyndai.Entity.Order;
import poly.dn.huyndai.Repository.OrderRepsitory;
import poly.dn.huyndai.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    
    private final OrderRepsitory orderRepsitory;
    @Override
	public List<Order> searhByAmount(Double min){
		return orderRepsitory.searhByAmount(min);
	}
    public OrderServiceImpl(OrderRepsitory orderRepsitory) {
        this.orderRepsitory = orderRepsitory;
    }

    @Override
    public long count() {
        return orderRepsitory.count();
    }

    @Override
    public <S extends Order> long count(Example<S> example) {
        return orderRepsitory.count(example);
    }

    @Override
    public void delete(Order entity) {
        orderRepsitory.delete(entity);
    }

    @Override
    public void deleteAll() {
        orderRepsitory.deleteAll();
    }

    @Override
    public void deleteAll(Iterable<? extends Order> entities) {
        orderRepsitory.deleteAll(entities);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        orderRepsitory.deleteAllById(ids);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        orderRepsitory.deleteAllByIdInBatch(ids);
    }

    @Override
    public void deleteAllInBatch() {
        orderRepsitory.deleteAllInBatch();
    }

    @Override
    public void deleteAllInBatch(Iterable<Order> entities) {
        orderRepsitory.deleteAllInBatch(entities);
    }

    @Override
    public void deleteById(Long id) {
        orderRepsitory.deleteById(id);
    }

    @Override
    public void deleteInBatch(Iterable<Order> entities) {
        orderRepsitory.deleteInBatch(entities);
    }

    @Override
    public <S extends Order> boolean exists(Example<S> example) {
        return orderRepsitory.exists(example);
    }

    @Override
    public boolean existsById(Long id) {
        return orderRepsitory.existsById(id);
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example) {
        return orderRepsitory.findAll(example);
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
        return orderRepsitory.findAll(example, sort);
    }

    @Override
    public List<Order> findAll() {
        return orderRepsitory.findAll();
    }

    @Override
    public List<Order> findAll(Sort sort) {
        return orderRepsitory.findAll(sort);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepsitory.findAll(pageable);
    }

    @Override
    public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
        return orderRepsitory.findAll(example, pageable);
    }

    @Override
    public List<Order> findAllById(Iterable<Long> ids) {
        return orderRepsitory.findAllById(ids);
    }

    @Override
    public <S extends Order, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return orderRepsitory.findBy(example, queryFunction);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepsitory.findById(id);
    }

    @Override
    public <S extends Order> Optional<S> findOne(Example<S> example) {
        return orderRepsitory.findOne(example);
    }

    @Override
    public void flush() {
        orderRepsitory.flush();
    }

    @Override
    public Order getById(Long arg0) {
        return orderRepsitory.getById(arg0);
    }

    @Override
    public Order getOne(Long arg0) {
        return orderRepsitory.getOne(arg0);
    }

    @Override
    public Order getReferenceById(Long id) {
        return orderRepsitory.getReferenceById(id);
    }

    @Override
    public <S extends Order> S save(S entity) {
        return orderRepsitory.save(entity);
    }

    @Override
    public <S extends Order> List<S> saveAll(Iterable<S> entities) {
        return orderRepsitory.saveAll(entities);
    }

    @Override
    public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
        return orderRepsitory.saveAllAndFlush(entities);
    }

    @Override
    public <S extends Order> S saveAndFlush(S entity) {
        return orderRepsitory.saveAndFlush(entity);
    }

    
}
