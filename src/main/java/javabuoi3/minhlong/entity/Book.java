package javabuoi3.minhlong.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name ="book")
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="title")
    private String title;
    @Column(name ="author")
    private String author;
    @Column(name ="price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categogy category;
}