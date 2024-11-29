package com.yvh.vision.web.rest.converter;

import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public interface Converter<A, B> {
    default A toEntity(final B dto) {
        throw new NotImplementedException();
    }

    default B toDto(final A entity) {
        throw new NotImplementedException();
    }

    default List<A> toEntity(final List<B> dtos) {
        throw new NotImplementedException();
    }

    default List<B> toDto(final List<A> entities) {
        throw new NotImplementedException();
    }


}
