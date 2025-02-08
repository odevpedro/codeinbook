package com.rasmoo.codeinbook.domain.service;

import com.rasmoo.codeinbook.common.dto.BookDto;
import com.rasmoo.codeinbook.domain.port.out.BookRepositoryPort;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class BookService {

    private BookService bookService;
    private BookRepositoryPort bookRepositoryPort;

    public BookDto create(BookDto dto){
    return bookRepositoryPort.create(dto);
    }

}
