package com.yvh.vision.web.rest.converter;

import com.yvh.vision.application.util.Validator;
import com.yvh.vision.core.model.ScanDataTarget;
import com.yvh.vision.web.rest.model.ScanDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScanConverter implements Converter<ScanDataTarget, ScanDto> {
    private final TargetConverter targetConverter;

    public ScanConverter(TargetConverter targetConverter) {
        this.targetConverter = targetConverter;
    }

    @Override
    public ScanDataTarget toEntity(ScanDto dto) {
        return new ScanDataTarget(dto.getCoordinates(), targetConverter.toEntity(dto.getTarget()), dto.getAllies());
    }

    @Override
    public List<ScanDataTarget> toEntity(List<ScanDto> dtos) {
        Validator.notEmpty(dtos, " mapping dto list");
        ArrayList<ScanDataTarget> entities = new ArrayList<>(dtos.size());
        for (ScanDto dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
}
