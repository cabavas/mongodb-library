package com.caio.library.resources;

import com.caio.library.dto.BookDTO;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.caio.library.entities.Book;
import com.caio.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value = "/books")
public class BookResource {

    @Autowired
    private BookService service;
    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll() {
        List<Book> books = service.findAll();
        List<BookDTO> booksDTO = books.stream().map(x -> new BookDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(booksDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable String id) {
        Book obj = service.findById(id);
        return ResponseEntity.ok().body(new BookDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody BookDTO bookDTO) {
        Book obj = service.fromDTO(bookDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody BookDTO objDto, @PathVariable String id) {
        Book obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
