package poly.dn.huyndai.Entity;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
	@Id
	@Column(nullable = false, columnDefinition = "nvarchar(255)")
	private String username;
    @Column(nullable = false, columnDefinition = "nvarchar(255)")
	private String name;
	@Column(nullable = false, columnDefinition = "nvarchar(255)")
	private String email;
	@Column(nullable = false, columnDefinition = "nvarchar(255)")
	private String phone;

	private String address;
	@Column(nullable = false, columnDefinition = "nvarchar(255)")
	private String password;
	
	
	@OneToMany(mappedBy = "customer")
	List<Order> orders;
	
	
	@OneToMany(mappedBy = "customer")
	List<Bill> bills;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	List<Authority> authorities;

	@OneToMany(mappedBy = "customer")
	List<New> news;
}

