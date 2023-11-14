package poly.dn.huyndai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.dn.huyndai.Entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
    
}
