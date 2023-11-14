package poly.dn.huyndai.Entity;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "news_images")
public class NewsImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private New news;

    @Column(nullable = false, columnDefinition = "nvarchar(MAX)")
    private String titles;

    @Column(nullable = false ,name="contnet_text",columnDefinition = "nvarchar(MAX)")
    private String contents;

    @Column(nullable = false , columnDefinition = "nvarchar(255)")
    private String image;

    @Temporal(TemporalType.DATE)
    private Date createdDate;
}

