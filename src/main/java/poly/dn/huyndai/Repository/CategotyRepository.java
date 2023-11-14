package poly.dn.huyndai.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import poly.dn.huyndai.Entity.Category;

public interface CategotyRepository extends JpaRepository<Category , Integer> {
    List<Category> findByNameContaining(String name);
	Page<Category> findByNameContaining(String name,Pageable pageable);
}
