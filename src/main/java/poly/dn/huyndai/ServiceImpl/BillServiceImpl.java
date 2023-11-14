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

import poly.dn.huyndai.Entity.Bill;
import poly.dn.huyndai.Repository.BillRepository;
import poly.dn.huyndai.Service.BillService;

@Service
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public long count() {
        return billRepository.count();
    }

    @Override
    public <S extends Bill> long count(Example<S> example) {
        return billRepository.count(example);
    }

    @Override
    public void delete(Bill entity) {
        billRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        billRepository.deleteAll();
    }

    @Override
    public void deleteAll(Iterable<? extends Bill> entities) {
        billRepository.deleteAll(entities);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        billRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        billRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void deleteAllInBatch() {
        billRepository.deleteAllInBatch();
    }

    @Override
    public void deleteAllInBatch(Iterable<Bill> entities) {
        billRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteById(Long id) {
        billRepository.deleteById(id);
    }

    @Override
    public void deleteInBatch(Iterable<Bill> entities) {
        billRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends Bill> boolean exists(Example<S> example) {
        return billRepository.exists(example);
    }

    @Override
    public boolean existsById(Long id) {
        return billRepository.existsById(id);
    }

    @Override
    public <S extends Bill> List<S> findAll(Example<S> example) {
        return billRepository.findAll(example);
    }

    @Override
    public <S extends Bill> List<S> findAll(Example<S> example, Sort sort) {
        return billRepository.findAll(example, sort);
    }

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public List<Bill> findAll(Sort sort) {
        return billRepository.findAll(sort);
    }

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @Override
    public <S extends Bill> Page<S> findAll(Example<S> example, Pageable pageable) {
        return billRepository.findAll(example, pageable);
    }

    @Override
    public List<Bill> findAllById(Iterable<Long> ids) {
        return billRepository.findAllById(ids);
    }

    @Override
    public <S extends Bill, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return billRepository.findBy(example, queryFunction);
    }

    @Override
    public Optional<Bill> findById(Long id) {
        return billRepository.findById(id);
    }

    @Override
    public <S extends Bill> Optional<S> findOne(Example<S> example) {
        return billRepository.findOne(example);
    }

    @Override
    public void flush() {
        billRepository.flush();
    }

    @Override
    public Bill getById(Long arg0) {
        return billRepository.getById(arg0);
    }

    @Override
    public Bill getOne(Long arg0) {
        return billRepository.getOne(arg0);
    }

    @Override
    public Bill getReferenceById(Long id) {
        return billRepository.getReferenceById(id);
    }

    @Override
    public <S extends Bill> S save(S entity) {
        return billRepository.save(entity);
    }

    @Override
    public <S extends Bill> List<S> saveAll(Iterable<S> entities) {
        return billRepository.saveAll(entities);
    }

    @Override
    public <S extends Bill> List<S> saveAllAndFlush(Iterable<S> entities) {
        return billRepository.saveAllAndFlush(entities);
    }

    @Override
    public <S extends Bill> S saveAndFlush(S entity) {
        return billRepository.saveAndFlush(entity);
    }

    
}
