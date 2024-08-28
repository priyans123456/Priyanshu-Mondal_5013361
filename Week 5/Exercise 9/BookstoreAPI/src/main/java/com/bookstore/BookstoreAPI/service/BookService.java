package com.bookstore.BookstoreAPI.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bookstore.BookstoreAPI.dto.BookDTO;
import com.bookstore.BookstoreAPI.model.Book;
import com.bookstore.BookstoreAPI.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        book = bookRepository.save(book);
        return modelMapper.map(book, BookDTO.class);
    }

    public BookDTO getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(value -> modelMapper.map(value, BookDTO.class)).orElse(null);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    modelMapper.map(bookDTO, existingBook);
                    Book updatedBook = bookRepository.save(existingBook);
                    return modelMapper.map(updatedBook, BookDTO.class);
                }).orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}