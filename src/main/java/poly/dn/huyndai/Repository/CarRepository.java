package poly.dn.huyndai.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import poly.dn.huyndai.Entity.Car;



public interface CarRepository extends JpaRepository<Car, Integer>{
    @Query("Select p from Car p where p.category.id = ?1")
	List<Car> findByCategoryId(String id);

    Page<Car> findByNameContaining(String name, Pageable pageable);

    List<Car> findByNameContaining(String name);

    List<Car> findByPriceBetween(double minPrice, double maxPrice );

}
