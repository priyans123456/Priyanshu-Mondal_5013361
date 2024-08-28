package com.bookstore.BookstoreAPI.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookDTO {

    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Author is mandatory")
    private String author;

    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price must be a positive value")
    private Double price;

    @NotBlank(message = "ISBN is mandatory")
    private String isbn;
}
