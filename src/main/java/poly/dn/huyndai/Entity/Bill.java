package poly.dn.huyndai.Entity;


import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="bills")
public class Bill  implements Serializable{
	@Id
	private Long billId;

	
	@Temporal(TemporalType.DATE)
	private Date billDate;
	private Double price;
	private Double totalAmount;
	
	private boolean paymentStatus;
	@Column( columnDefinition = "nvarchar(255)")
	private String paymentMethods;
	
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	Order order;
	
	@ManyToOne
	@JoinColumn(name = "customer")
	Customer customer;
}
