package poly.dn.huyndai.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import poly.dn.huyndai.Entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, String>{
   @Query("Select Distinct cs.customer from Authority cs where cs.role.id in ('DIRE','STAF')")
   List<Customer> getAdminOrStaff();

   void save(UserDetails user);

    Customer findByEmail(String email);

    List<Customer> findByNameContaining(String name);
	
	@Query("SELECT o FROM Customer o WHERE o.username = ?1")
	public Optional<Customer> searchById(String min);
	
	@Query("DELETE  FROM Customer o WHERE o.username = ?1")
	public Optional<Customer> deleteByUsername(String min);
}
