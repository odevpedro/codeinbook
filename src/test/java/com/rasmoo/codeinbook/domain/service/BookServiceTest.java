package com.rasmoo.codeinbook.domain.service;

import com.rasmoo.codeinbook.common.dto.BookDto;
import com.rasmoo.codeinbook.common.dto.PageDTO;
import com.rasmoo.codeinbook.domain.port.out.BookRepositoryPort;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepositoryPort bookRepositoryPort;
    @InjectMocks
    private BookService bookService;


    @Test
    void shouldCreateNewBook() {
        BookDto bookDTO = new BookDto("", "Partindo do zero com java", "aprenda a programar agora", "", BigDecimal.valueOf(29.90));
        BookDto bookSaved = getBookSaved();
        when(bookRepositoryPort.create(bookDTO)).thenReturn(bookSaved);
        assertEquals(bookSaved, bookService.create(bookDTO));
        verify(bookRepositoryPort, times(1)).create(bookDTO);
    }

    @Test
    void shouldUpdateBook() {
        BookDto bookSaved = getBookSaved();
        bookService.update("123",bookSaved);
        verify(bookRepositoryPort, times(1)).update("123", bookSaved);

    }

    @Test
    void shouldGetBookById() {
        BookDto bookSaved = getBookSaved();
        when(bookRepositoryPort.findById("123")).thenReturn(bookSaved);
        assertEquals(bookSaved, bookService.findById("123"));
    }

    @Test
    void shouldDeleteBook() {
        bookService.delete("123");
        verify(bookRepositoryPort, times(1)).delete("123");
    }

    @Test
    void shouldGetAllBooksPaged() {
        List<BookDto> bookList = List.of(getBookSaved());

        PageDTO<BookDto> page = PageDTO.<BookDto>builder()
                .content(bookList)
                .page(0)
                .size(10)
                .totalElements(1000)
                .totalPages(100)
                .build();

        when(bookRepositoryPort.findAll(0,10)).thenReturn(page);
        assertEquals(page, bookService.findAll(0,10));
    }

    private static BookDto getBookSaved() {
        return new BookDto("123", "Partindo do zero com java", "aprenda a programar agora", "", BigDecimal.valueOf(29.90));
    }



}