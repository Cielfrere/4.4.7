package models.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import models.request.SaveAuthors;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponse {
    private String bookTittle;
    private SaveAuthors authors;
}
