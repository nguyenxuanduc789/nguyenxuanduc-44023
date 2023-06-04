package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
@Data
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    @NotEmpty(message = "Tên không được để trống")
    @Size(max = 50, min = 1, message = "Tên không vượt quá 50 ký tự")
    private String name;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Book>books;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Category() {
    }

    public Category(Long id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

}
