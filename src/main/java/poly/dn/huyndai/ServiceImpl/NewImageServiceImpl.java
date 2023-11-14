package poly.dn.huyndai.ServiceImpl;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;
import poly.dn.huyndai.Entity.NewsImage;
import poly.dn.huyndai.Repository.NewImageRepository;
import poly.dn.huyndai.Service.NewImageService;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class NewImageServiceImpl implements NewImageService {
    private final NewImageRepository newArrayRepository;


    public NewImageServiceImpl(NewImageRepository newArrayRepository) {
        this.newArrayRepository = newArrayRepository;
    }


	@Override
	public <S extends NewsImage> S save(S entity) {
		return newArrayRepository.save(entity);
	}


	@Override
	public <S extends NewsImage> List<S> saveAll(Iterable<S> entities) {
		return newArrayRepository.saveAll(entities);
	}


	@Override
	public <S extends NewsImage> Optional<S> findOne(Example<S> example) {
		return newArrayRepository.findOne(example);
	}


	@Override
	public List<NewsImage> findAll(Sort sort) {
		return newArrayRepository.findAll(sort);
	}


	@Override
	public void flush() {
		newArrayRepository.flush();
	}


	@Override
	public Page<NewsImage> findAll(Pageable pageable) {
		return newArrayRepository.findAll(pageable);
	}


	@Override
	public <S extends NewsImage> S saveAndFlush(S entity) {
		return newArrayRepository.saveAndFlush(entity);
	}


	@Override
	public <S extends NewsImage> List<S> saveAllAndFlush(Iterable<S> entities) {
		return newArrayRepository.saveAllAndFlush(entities);
	}


	@Override
	public List<NewsImage> findAll() {
		return newArrayRepository.findAll();
	}


	@Override
	public List<NewsImage> findAllById(Iterable<Long> ids) {
		return newArrayRepository.findAllById(ids);
	}


	@Override
	public void deleteInBatch(Iterable<NewsImage> entities) {
		newArrayRepository.deleteInBatch(entities);
	}


	@Override
	public <S extends NewsImage> Page<S> findAll(Example<S> example, Pageable pageable) {
		return newArrayRepository.findAll(example, pageable);
	}


	@Override
	public Optional<NewsImage> findById(Long id) {
		return newArrayRepository.findById(id);
	}


	@Override
	public void deleteAllInBatch(Iterable<NewsImage> entities) {
		newArrayRepository.deleteAllInBatch(entities);
	}


	@Override
	public boolean existsById(Long id) {
		return newArrayRepository.existsById(id);
	}


	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		newArrayRepository.deleteAllByIdInBatch(ids);
	}


	@Override
	public <S extends NewsImage> long count(Example<S> example) {
		return newArrayRepository.count(example);
	}


	@Override
	public <S extends NewsImage> boolean exists(Example<S> example) {
		return newArrayRepository.exists(example);
	}


	@Override
	public void deleteAllInBatch() {
		newArrayRepository.deleteAllInBatch();
	}


	@Override
	public NewsImage getOne(Long id) {
		return newArrayRepository.getOne(id);
	}


	@Override
	public <S extends NewsImage, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return newArrayRepository.findBy(example, queryFunction);
	}


	@Override
	public long count() {
		return newArrayRepository.count();
	}


	@Override
	public void deleteById(Long id) {
		newArrayRepository.deleteById(id);
	}


	@Override
	public NewsImage getById(Long id) {
		return newArrayRepository.getById(id);
	}


	@Override
	public void delete(NewsImage entity) {
		newArrayRepository.delete(entity);
	}


	@Override
	public NewsImage getReferenceById(Long id) {
		return newArrayRepository.getReferenceById(id);
	}


	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		newArrayRepository.deleteAllById(ids);
	}


	@Override
	public void deleteAll(Iterable<? extends NewsImage> entities) {
		newArrayRepository.deleteAll(entities);
	}


	@Override
	public <S extends NewsImage> List<S> findAll(Example<S> example) {
		return newArrayRepository.findAll(example);
	}


	@Override
	public <S extends NewsImage> List<S> findAll(Example<S> example, Sort sort) {
		return newArrayRepository.findAll(example, sort);
	}


	@Override
	public void deleteAll() {
		newArrayRepository.deleteAll();
	}

}
