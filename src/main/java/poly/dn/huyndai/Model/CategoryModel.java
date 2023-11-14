package poly.dn.huyndai.Model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel implements Serializable {
	private Integer id;
	private String name;
	private Boolean isEdit = false;
}
