package Models.Requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetBooks {
    private String authors_id;
}
