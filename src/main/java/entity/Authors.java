package entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Authors {
    private long id;
    private String firstName;
    private String secondName;
    private String familyName;
}
