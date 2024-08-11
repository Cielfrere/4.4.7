package models.request;

import entity.Authors;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetBooksXML {
    private Authors author;
}
