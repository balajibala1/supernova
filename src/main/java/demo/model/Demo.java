package demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Demo {
    private Integer id;
    private String name;
    private String emailid;
    private Integer phone_number;
}
