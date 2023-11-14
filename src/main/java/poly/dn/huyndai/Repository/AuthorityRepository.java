package poly.dn.huyndai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import poly.dn.huyndai.Entity.Authority;
import poly.dn.huyndai.Entity.Customer;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Integer>{

    @Query ("Select Distinct a from Authority a where a.customer in ?1")
    List<Authority> authoritiesOf(List<Customer> customers);
}
