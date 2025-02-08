package com.rasmoo.codeinbook.domain.port.out;

import com.rasmoo.codeinbook.common.dto.BookDto;

public interface BookRepositoryPort {
    BookDto create(BookDto bookDto);
}
