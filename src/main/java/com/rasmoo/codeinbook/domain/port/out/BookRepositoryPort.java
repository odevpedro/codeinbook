package com.rasmoo.codeinbook.domain.port.out;

import com.rasmoo.codeinbook.common.dto.BookDto;
import com.rasmoo.codeinbook.common.dto.PageDTO;

public interface BookRepositoryPort {
    BookDto create(BookDto dto);

    void update(String id, BookDto dto);

    BookDto findById(String id);

    void delete(String id);

    PageDTO<BookDto> findAll(int page, int size);
}
