package io.github.luaprogrammer.trade_map.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude = {"user"})
@Entity
@Table(name = "FAVORITES_ACTIONS")
public class FavoriteAction extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "FA_USER_ID", nullable = false)
    private User user;

    @Column(name = "FA_CODE", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID code;
}
