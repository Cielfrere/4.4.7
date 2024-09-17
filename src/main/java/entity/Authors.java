package entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "author")
public class Authors {

    @XmlElement(name = "id")
    @JsonProperty("id")
    private long id;

    @XmlElement(name = "first_name")
    @JsonProperty("firstName")
    private String firstName;

    @XmlElement(name = "family_name")
    @JsonProperty("familyName")
    private String familyName;

    @XmlElement(name = "second_name")
    @JsonProperty("secondName")
    private String secondName;
}
