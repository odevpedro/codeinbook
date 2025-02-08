package com.rasmoo.codeinbook.domain.service;

import com.rasmoo.codeinbook.common.dto.BookDto;
import com.rasmoo.codeinbook.domain.port.out.BookRepositoryPort;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@AllArgsConstructor
public class BookServiceTest {

    @Mock
    private BookRepositoryPort bookRepositoryPort;

    @InjectMocks
    private BookService bookService;

    @Test
    void shouldCreateNewBook(){
        BookDto bookDto = new BookDto("",
                "Partindo do zero com java",
                "aprenda a programamr",
                "qualquer descrição",
                BigDecimal.valueOf(2323));

        BookDto bookSaved = new BookDto("123",
        "Partindo do zero com java",
        "aprenda a programamr",
        "qualquer descrição",
        BigDecimal.valueOf(2323));
        when(bookRepositoryPort.create(bookDto)).thenReturn(bookSaved);

        Assertions.assertEquals(bookSaved, bookService.create(bookDto));
        verify(bookRepositoryPort, times(1)).create(bookDto);

    }


}
