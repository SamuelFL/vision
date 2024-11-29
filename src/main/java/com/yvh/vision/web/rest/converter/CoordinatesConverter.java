package com.yvh.vision.web.rest.converter;

import com.yvh.vision.application.util.Validator;
import com.yvh.vision.core.model.Coordinates;
import com.yvh.vision.web.rest.model.TargetCoordinatesDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoordinatesConverter implements Converter<Coordinates, TargetCoordinatesDto> {

    @Override
    public TargetCoordinatesDto toDto(Coordinates entity) {
        return new TargetCoordinatesDto(entity.x(), entity.y());
    }

    @Override
    public List<TargetCoordinatesDto> toDto(List<Coordinates> entities) {
        Validator.notEmpty(entities, " mapping dto list");
        ArrayList<TargetCoordinatesDto> dtos = new ArrayList<>(entities.size());
        for (Coordinates entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
