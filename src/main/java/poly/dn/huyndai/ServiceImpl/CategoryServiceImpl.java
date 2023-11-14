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

import poly.dn.huyndai.Entity.Category;
import poly.dn.huyndai.Repository.CategotyRepository;
import poly.dn.huyndai.Service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService  {
    
    private final  CategotyRepository categotyRepository;

    public CategoryServiceImpl(CategotyRepository categotyRepository) {
        this.categotyRepository = categotyRepository;
    }
    @Override
	public List<Category> findByNameContaining(String name) {
		return categotyRepository.findByNameContaining(name);
	}
    @Override
	public Page<Category> findByNameContaining(String name, Pageable pageable) {
		return categotyRepository.findByNameContaining(name, pageable);
	}
    @Override
    public <S extends Category> S save(S entity) {
        return categotyRepository.save(entity);
    }

    @Override
    public <S extends Category> List<S> saveAll(Iterable<S> entities) {
        return categotyRepository.saveAll(entities);
    }

    @Override
    public <S extends Category> Optional<S> findOne(Example<S> example) {
        return categotyRepository.findOne(example);
    }

    @Override
    public List<Category> findAll(Sort sort) {
        return categotyRepository.findAll(sort);
    }

    @Override
    public void flush() {
        categotyRepository.flush();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categotyRepository.findAll(pageable);
    }

    @Override
    public <S extends Category> S saveAndFlush(S entity) {
        return categotyRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
        return categotyRepository.saveAllAndFlush(entities);
    }

    @Override
    public List<Category> findAll() {
        return categotyRepository.findAll();
    }

    @Override
    public List<Category> findAllById(Iterable<Integer> ids) {
        return categotyRepository.findAllById(ids);
    }

    @Override
    public void deleteInBatch(Iterable<Category> entities) {
        categotyRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
        return categotyRepository.findAll(example, pageable);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categotyRepository.findById(id);
    }

    @Override
    public void deleteAllInBatch(Iterable<Category> entities) {
        categotyRepository.deleteAllInBatch(entities);
    }

    @Override
    public boolean existsById(Integer id) {
        return categotyRepository.existsById(id);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        categotyRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public <S extends Category> long count(Example<S> example) {
        return categotyRepository.count(example);
    }

    @Override
    public <S extends Category> boolean exists(Example<S> example) {
        return categotyRepository.exists(example);
    }

    @Override
    public void deleteAllInBatch() {
        categotyRepository.deleteAllInBatch();
    }

    @Override
    public Category getOne(Integer id) {
        return categotyRepository.getOne(id);
    }

    @Override
    public <S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return categotyRepository.findBy(example, queryFunction);
    }

    @Override
    public long count() {
        return categotyRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        categotyRepository.deleteById(id);
    }

    @Override
    public Category getById(Integer id) {
        return categotyRepository.getById(id);
    }

    @Override
    public void delete(Category entity) {
        categotyRepository.delete(entity);
    }

    @Override
    public Category getReferenceById(Integer id) {
        return categotyRepository.getReferenceById(id);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        categotyRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends Category> entities) {
        categotyRepository.deleteAll(entities);
    }

    @Override
    public <S extends Category> List<S> findAll(Example<S> example) {
        return categotyRepository.findAll(example);
    }

    @Override
    public <S extends Category> List<S> findAll(Example<S> example, Sort sort) {
        return categotyRepository.findAll(example, sort);
    }

    @Override
    public void deleteAll() {
        categotyRepository.deleteAll();
    }

    
    
}
