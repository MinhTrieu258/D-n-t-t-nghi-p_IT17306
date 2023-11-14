package poly.dn.huyndai.Model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillModel implements Serializable {
	private Integer billId;
	private Date billDate;
	private Double price;
	private Double totalAmount;
	private boolean paymentStatus;
	private String paymentMethods;
	private Integer orderId;
	private String username;
	private Boolean isEdit = false;
}
