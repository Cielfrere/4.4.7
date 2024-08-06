package Models.Requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaveAuthors {
    private String first_name;
    private String second_name;
    private String family_name;
}
