package Models.Requests;

import Objects.Authors;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaveBooks {
    private String book_title;
    private Authors author;
}
