package poly.dn.huyndai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.dn.huyndai.Entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
    
}
