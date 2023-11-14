package poly.dn.huyndai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.dn.huyndai.Entity.Order;

public interface OrderRepsitory extends JpaRepository<Order, Long>{
    @Query("SELECT o FROM Order o WHERE o.price = ?1")
	public List<Order> searhByAmount(Double min);
}
