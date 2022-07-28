package sample.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer team_no;
    private Integer score;

    public Team() {
    }


}
