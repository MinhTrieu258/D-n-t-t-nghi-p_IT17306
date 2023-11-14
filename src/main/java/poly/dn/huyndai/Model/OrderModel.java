package poly.dn.huyndai.Model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel implements Serializable {
	private Long orderId;
	private String username;
	private Integer carId;
	private Date orderDate;
	private String address;
	private Integer quantity;
	private Double price;
	private Boolean isEdit = false;
}
