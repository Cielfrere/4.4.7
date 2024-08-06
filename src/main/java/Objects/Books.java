package Objects;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Books {
    private long id;
    private String book_title;
    private Authors author;

}
