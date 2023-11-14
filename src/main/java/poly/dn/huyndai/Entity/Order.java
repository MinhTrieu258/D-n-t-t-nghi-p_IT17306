package poly.dn.huyndai.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@Temporal(TemporalType.DATE)
	private Date orderDate;
@Column(nullable = false, columnDefinition = "nvarchar(255)")
	private String address;

	private Integer quantity;
	
	private Double price;

	
	@ManyToOne
	@JoinColumn(name = "username")
	Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "carId")
	Car car;
	
	@OneToMany(mappedBy = "order")
	List<OrderDetail> orderDetails;
	
	@OneToMany(mappedBy = "billId")
	List<Bill> bills;
}
