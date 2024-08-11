package models.request;

import entity.Authors;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaveBooks {
    private String bookTitle;
    private Authors author;
}
