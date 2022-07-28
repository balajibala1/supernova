package sample.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Er_diagram;
    private String userStrory1;
    private String userStrory2;
    private String userStrory3;
    private String team_id;
    private Integer score;

}
