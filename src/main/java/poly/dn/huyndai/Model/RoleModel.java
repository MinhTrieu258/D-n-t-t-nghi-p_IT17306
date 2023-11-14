package poly.dn.huyndai.Model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleModel implements Serializable {
	private String RoleId;
	private String name;
}
