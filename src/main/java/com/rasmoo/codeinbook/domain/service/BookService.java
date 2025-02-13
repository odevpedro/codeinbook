package com.rasmoo.codeinbook.domain.service;

import com.rasmoo.codeinbook.common.dto.BookDto;
import com.rasmoo.codeinbook.common.dto.PageDTO;
import com.rasmoo.codeinbook.domain.port.out.BookRepositoryPort;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class BookService {

    private BookRepositoryPort bookRepositoryPort;

    public BookDto create(BookDto dto) {
        return bookRepositoryPort.create(dto);
    }

    public void update(String id, BookDto dto) {
        bookRepositoryPort.update(id, dto);
    }


    public BookDto findById(String id) {
        return bookRepositoryPort.findById(id);
    }

    public void delete(String id) {
        bookRepositoryPort.delete(id);
    }

    public PageDTO<BookDto> findAll(int page, int size) {
        return bookRepositoryPort.findAll(page, size);
    }
}
