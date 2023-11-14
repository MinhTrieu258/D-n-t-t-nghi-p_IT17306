package poly.dn.huyndai.Entity;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cars")
public class Car implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String model;
    @Column(nullable = false, columnDefinition = "nvarchar(255)")
	private String name;
	private Double price;
    @Column(columnDefinition = "nvarchar(255)")
	private String image;
	
    @Column(nullable = false, columnDefinition = "nvarchar(MAX)")
  	private String description;
    
    @Column(columnDefinition = "nvarchar(255)")
  	private String image2;
    
    @Column(columnDefinition = "nvarchar(255)")
  	private String image3;
    
    @Column(columnDefinition = "nvarchar(255)")
  	private String image4;
    
	@ManyToOne
	@JoinColumn(name = "categoryId")
	Category category;
	
	@OneToMany(mappedBy = "car")
	List<Comment> comments;
	
	@OneToMany(mappedBy = "car")
	List<Order> orders;	
	
}
