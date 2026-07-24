package com.diacore.domain.common.model;

import java.util.List;

public record PageResult<T>(
        List<T> content,
        long totalElements,
        int pageNumber,
        int totalPages,
        int size,
        int number
) {}
