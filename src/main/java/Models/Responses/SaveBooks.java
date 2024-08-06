package Models.Responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveBooks {
    private long books_id;
    private Error error;
}
