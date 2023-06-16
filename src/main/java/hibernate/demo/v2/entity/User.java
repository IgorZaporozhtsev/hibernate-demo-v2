package hibernate.demo.v2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    private String username;
    private String firstname;
    private String lastname;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private Integer age; //why not primitive int


}
