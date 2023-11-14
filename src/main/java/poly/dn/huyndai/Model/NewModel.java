package poly.dn.huyndai.Model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewModel implements Serializable {
	private Long id;
	private String username;
	private Boolean isEdit = false;
}
