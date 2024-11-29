package com.yvh.vision.web.rest.converter;

import com.yvh.vision.application.util.Validator;
import com.yvh.vision.core.model.ProtocolName;
import com.yvh.vision.core.model.protocol.AssistAlliesProtocol;
import com.yvh.vision.core.model.protocol.AvoidCrossfireProtocol;
import com.yvh.vision.core.model.protocol.AvoidMechProtocol;
import com.yvh.vision.core.model.protocol.ClosestEnemiesProtocol;
import com.yvh.vision.core.model.protocol.FurthestEnemiesProtocol;
import com.yvh.vision.core.model.protocol.PrioritizeMechProtocol;
import com.yvh.vision.core.model.protocol.Protocol;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProtocolConverter implements Converter<Protocol, String> {
    @Override
    public Protocol toEntity(String protocolRequestName) {
        switch (ProtocolName.getEnum(protocolRequestName.toUpperCase().replace('-', '_'))) {
            case CLOSEST_ENEMIES -> {
                return new ClosestEnemiesProtocol();
            }
            case FURTHEST_ENEMIES -> {
                return new FurthestEnemiesProtocol();
            }
            case ASSIST_ALLIES -> {
                return new AssistAlliesProtocol();
            }
            case AVOID_CROSSFIRE -> {
                return new AvoidCrossfireProtocol();
            }
            case PRIORITIZE_MECH -> {
                return new PrioritizeMechProtocol();
            }
            case AVOID_MECH -> {
                return new AvoidMechProtocol();
            }
            default -> throw new NotImplementedException(protocolRequestName + " protocol not implemented.");
        }
    }

    @Override
    public List<Protocol> toEntity(List<String> dtos) {
        Validator.notEmpty(dtos, "Mapping dto list");
        ArrayList<Protocol> entities = new ArrayList<>(dtos.size());
        for (String dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
}
