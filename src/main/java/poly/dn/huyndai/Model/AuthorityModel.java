package poly.dn.huyndai.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityModel {
	private Integer AuthId;
	private String username;
	private String RoleId;
	private Boolean isEdit = false;
}
