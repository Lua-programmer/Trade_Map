package io.github.luaprogrammer.trade_map.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {

    @Column(name = "USER_LOGIN", nullable = false)
    private String login;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;

    @Column(name = "USER_EMAIL", nullable = false)
    private String email;

    @Column(name = "USER_NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<FavoriteAction> favoriteActions;

    @Column(name = "USER_ACTIVE", nullable = false)
    private Boolean isActive;
}
