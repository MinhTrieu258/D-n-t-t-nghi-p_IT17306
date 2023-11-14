package poly.dn.huyndai.Service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.dn.huyndai.Entity.NewsImage;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface NewImageService {

	void deleteAll();

	<S extends NewsImage> List<S> findAll(Example<S> example, Sort sort);

	<S extends NewsImage> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends NewsImage> entities);

	void deleteAllById(Iterable<? extends Long> ids);

	NewsImage getReferenceById(Long id);

	void delete(NewsImage entity);

	NewsImage getById(Long id);

	void deleteById(Long id);

	long count();

	<S extends NewsImage, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	NewsImage getOne(Long id);

	void deleteAllInBatch();

	<S extends NewsImage> boolean exists(Example<S> example);

	<S extends NewsImage> long count(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	boolean existsById(Long id);

	void deleteAllInBatch(Iterable<NewsImage> entities);

	Optional<NewsImage> findById(Long id);

	<S extends NewsImage> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<NewsImage> entities);

	List<NewsImage> findAllById(Iterable<Long> ids);

	List<NewsImage> findAll();

	<S extends NewsImage> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends NewsImage> S saveAndFlush(S entity);

	Page<NewsImage> findAll(Pageable pageable);

	void flush();

	List<NewsImage> findAll(Sort sort);

	<S extends NewsImage> Optional<S> findOne(Example<S> example);

	<S extends NewsImage> List<S> saveAll(Iterable<S> entities);

	<S extends NewsImage> S save(S entity);
   
}
