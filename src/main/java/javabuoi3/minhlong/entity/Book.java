package javabuoi3.minhlong.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import javabuoi3.minhlong.Validator.annotation.ValidCategoryId;
import javabuoi3.minhlong.Validator.annotation.ValidUserId;


import javabuoi3.minhlong.Validator.annotation.ValidUsername;
import lombok.Data;

@Data
@Entity
@Table (name ="book")
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="title")
    @NotEmpty(message = "Title mustt not be empty")
    @Size(max = 50, min = 1, message = "Title must be less than 50 characters")
    private String title;

    @Column(name ="author")
    private String author;

    @Column(name ="price")
    //annotation để ràng buộc việc nhập liệu,chú thích
    @NotNull(message = "Price is required")
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ValidCategoryId
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;
}
