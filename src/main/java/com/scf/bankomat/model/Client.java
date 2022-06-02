package com.scf.bankomat.model;

import lombok.*;

import javax.persistence.*;

// lombok
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//сущность шаблона
@Entity
//таблица account в бд создается через хибернейт без sql
@Table(name="account")

public class Client {
    //генерация id автоматический в БД
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstname;
    private String lastname;
    private Integer  balance;


}
