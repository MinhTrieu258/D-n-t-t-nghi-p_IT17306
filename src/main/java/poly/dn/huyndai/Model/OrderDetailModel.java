package poly.dn.huyndai.Model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailModel implements Serializable {
	private Long orderDetailId;
	private boolean status;
	private Date deliveryDate;
	private Long orderId;
	private Boolean isEdit = false;
}	
