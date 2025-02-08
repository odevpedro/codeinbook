package com.rasmoo.codeinbook.common.dto;

import java.math.BigDecimal;

public record BookDto(    String id,
                          String title,
                          String subTitle,
                          String description,
                          BigDecimal price) {

}
