package poly.dn.huyndai.Model;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel implements Serializable {
	@NotBlank(message = "Tên đăng nhập không được để trống")
	private String username;
	@NotBlank(message = "Họ và tên không được để trống")
	@Pattern(regexp = "^[\\p{L} ]+$", message = "Họ và tên chỉ được chứa chữ cái và khoảng trắng")
	private String name;
	@NotBlank(message = "Email không được để trống")
	@Email(message = "Email không hợp lệ")
	private String email;
	@NotBlank(message = "Số điện thoại không được để trống")
	@Pattern(regexp = "^[0-9]*$", message = "Số điện thoại chỉ được chứa số")
	@Min(value = 13, message = "Số điện thoại phải có ít nhất 13 chữ số")
	private String phone;

	private String address;

	@NotBlank(message = "Mật khẩu không được để trống")
	private String password;
	private Boolean isEdit = false;
	
}
