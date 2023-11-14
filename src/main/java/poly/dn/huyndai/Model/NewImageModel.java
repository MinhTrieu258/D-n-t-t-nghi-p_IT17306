package poly.dn.huyndai.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewImageModel implements Serializable {
   private Long id;
    private Long news_id;
    private String titles;
    private String contents;
    private String image;
    private Date createdDate;
    private Boolean isEdit = false;

}
