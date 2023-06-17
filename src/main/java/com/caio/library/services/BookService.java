package com.caio.library.services;

import com.caio.library.dto.BookDTO;
import com.caio.library.entities.Book;
import com.caio.library.repositories.BookRepository;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(String id) {
        Optional<Book> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectCollectedException("Book not found"));
    }

    public Book insert(Book obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public Book update(Book obj) {
        Book newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Book newObj, Book obj) {
        newObj.setTitle(obj.getTitle());
        newObj.setAuthor(obj.getAuthor());
    }

    public Book fromDTO(BookDTO obj) {
        return new Book(obj.getId(), obj.getTitle(), obj.getAuthor());
    }
}
