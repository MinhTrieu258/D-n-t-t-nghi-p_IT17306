package poly.dn.huyndai.Model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarModel implements Serializable{
	private Integer id;
	private Long categoryId;
	private String model;
	private String name;
	private Double price;
	private String image;
	private MultipartFile imageFile;
	private Boolean isEdit = false;
}
