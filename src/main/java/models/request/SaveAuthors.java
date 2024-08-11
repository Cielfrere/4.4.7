package models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaveAuthors {
    private long id;
    private String firstName;
    private String secondName;
    private String familyName;
}
