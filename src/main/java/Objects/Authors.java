package Objects;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Authors {
    private long id;
    private String first_name;
    private String second_name;
    private String family_name;
}
