package com.yvh.vision.web.rest.converter;

import com.yvh.vision.application.util.Validator;
import com.yvh.vision.core.model.EnemyType;
import com.yvh.vision.core.model.Target;
import com.yvh.vision.web.rest.model.ScanTargetDto;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TargetConverter implements Converter<Target, ScanTargetDto> {
    @Override
    public Target toEntity(ScanTargetDto dto) {
        switch (EnemyType.getEnum(dto.getType().toUpperCase())) {
            case MECH -> {
                return new Target(EnemyType.MECH, dto.getNumber());
            }
            case SOLDIER -> {
                return new Target(EnemyType.SOLDIER, dto.getNumber());
            }
            default -> throw new NotImplementedException("'" + dto.getType() + "' enemy type is not known");
        }
    }

    @Override
    public List<Target> toEntity(List<ScanTargetDto> dtos) {
        Validator.notEmpty(dtos, " mapping dto list");
        ArrayList<Target> entities = new ArrayList<>(dtos.size());
        for (ScanTargetDto dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
}
