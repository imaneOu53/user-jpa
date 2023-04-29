package ma.emsi.jpaapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(name = "USER_NAME",  unique = true, length = 20)
    private  String username;
    private String password;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)

    private List<Role> roles=new ArrayList<>();
}
