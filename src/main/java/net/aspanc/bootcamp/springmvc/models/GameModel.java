package net.aspanc.bootcamp.springmvc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Games")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name = "steam_id")
    private Integer steamId;
}
