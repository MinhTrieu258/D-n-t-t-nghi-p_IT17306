package poly.dn.huyndai.Model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentModel implements Serializable{
	private Integer cmtId;
	private Integer carId;
	private String cmtCar;
	private Date cmtDate;
	private Boolean isEdit = false;
}
