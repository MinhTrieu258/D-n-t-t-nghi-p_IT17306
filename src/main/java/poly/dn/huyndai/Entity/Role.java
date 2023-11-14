package poly.dn.huyndai.Entity;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="roles")
public class Role implements Serializable{
	@Id
	private String RoleId;
	private String RoleName;
	@OneToMany(mappedBy = "role")
	List<Authority> authorities;
}
