package poly.dn.huyndai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.dn.huyndai.Entity.Role;
public interface RoleRepository extends JpaRepository<Role, String> {
    
}

