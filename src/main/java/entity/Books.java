package entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Books {
    private long id;
    private String bookTittle;
    private long authorId;

}
