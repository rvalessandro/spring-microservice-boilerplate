package com.systeric.springmicroserviceboilerplate.infrastructure.entities.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity(name = "users")
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private int age;

    @Column
    @NotNull
    private String address;


}