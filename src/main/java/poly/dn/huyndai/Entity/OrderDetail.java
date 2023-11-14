package poly.dn.huyndai.Entity;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "orderdetails")
public class OrderDetail implements Serializable{
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long orderDetailId;

	private boolean status;
	@Temporal(TemporalType.DATE)
	private Date deliveryDate;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	Order order;
}
