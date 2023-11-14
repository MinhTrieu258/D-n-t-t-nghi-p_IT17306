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

import poly.dn.huyndai.Entity.Comment;
import poly.dn.huyndai.Repository.CommentRepository;
import poly.dn.huyndai.Service.CommentService;

@Service
public class CommentServiceImpl  implements CommentService{
	
	private  CommentRepository commentrepository;

	@Override
	public <S extends Comment> S save(S entity) {
		return commentrepository.save(entity);
	}

	@Override
	public <S extends Comment> List<S> saveAll(Iterable<S> entities) {
		return commentrepository.saveAll(entities);
	}

	@Override
	public <S extends Comment> Optional<S> findOne(Example<S> example) {
		return commentrepository.findOne(example);
	}

	@Override
	public List<Comment> findAll(Sort sort) {
		return commentrepository.findAll(sort);
	}

	@Override
	public void flush() {
		commentrepository.flush();
	}

	@Override
	public Page<Comment> findAll(Pageable pageable) {
		return commentrepository.findAll(pageable);
	}

	@Override
	public <S extends Comment> S saveAndFlush(S entity) {
		return commentrepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Comment> List<S> saveAllAndFlush(Iterable<S> entities) {
		return commentrepository.saveAllAndFlush(entities);
	}

	@Override
	public List<Comment> findAll() {
		return commentrepository.findAll();
	}

	@Override
	public List<Comment> findAllById(Iterable<Integer> ids) {
		return commentrepository.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<Comment> entities) {
		commentrepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Comment> Page<S> findAll(Example<S> example, Pageable pageable) {
		return commentrepository.findAll(example, pageable);
	}

	@Override
	public Optional<Comment> findById(Integer id) {
		return commentrepository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<Comment> entities) {
		commentrepository.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return commentrepository.existsById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		commentrepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Comment> long count(Example<S> example) {
		return commentrepository.count(example);
	}

	@Override
	public <S extends Comment> boolean exists(Example<S> example) {
		return commentrepository.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		commentrepository.deleteAllInBatch();
	}

	@Override
	public Comment getOne(Integer id) {
		return commentrepository.getOne(id);
	}

	@Override
	public <S extends Comment, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return commentrepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return commentrepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		commentrepository.deleteById(id);
	}

	@Override
	public Comment getById(Integer id) {
		return commentrepository.getById(id);
	}

	@Override
	public void delete(Comment entity) {
		commentrepository.delete(entity);
	}

	@Override
	public Comment getReferenceById(Integer id) {
		return commentrepository.getReferenceById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		commentrepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Comment> entities) {
		commentrepository.deleteAll(entities);
	}

	@Override
	public <S extends Comment> List<S> findAll(Example<S> example) {
		return commentrepository.findAll(example);
	}

	@Override
	public <S extends Comment> List<S> findAll(Example<S> example, Sort sort) {
		return commentrepository.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		commentrepository.deleteAll();
	}
	
}
