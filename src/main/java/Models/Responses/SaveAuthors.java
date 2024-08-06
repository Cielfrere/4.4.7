package Models.Responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveAuthors {
    private long author_id;
    private Error error;
}
