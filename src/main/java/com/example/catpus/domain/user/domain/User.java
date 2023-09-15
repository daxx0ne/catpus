package com.example.catpus.domain.user.domain;

import com.example.catpus.domain.model.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="USER")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name", "password", "role"})
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "univ")
    private String univ;

    @Column(name = "password")
    private String password;

    @Convert(converter = RoleTypeConverter.class)
    @Column(name = "role", nullable = false)
    private RoleType role;
}
