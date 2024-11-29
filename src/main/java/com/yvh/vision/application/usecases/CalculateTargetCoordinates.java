package com.yvh.vision.application.usecases;

import com.yvh.vision.application.commands.CalculateTargetCoordinatesCommand;
import com.yvh.vision.application.util.protocol.ProtocolManagerFactory;
import com.yvh.vision.core.model.ScanDataTarget;
import com.yvh.vision.core.model.exception.VisionError;
import com.yvh.vision.core.model.exception.VisionException;
import com.yvh.vision.core.model.protocol.MaxTargetDistanceProtocol;
import com.yvh.vision.core.model.protocol.Protocol;
import com.yvh.vision.core.model.protocol.ProtocolManager;
import com.yvh.vision.web.rest.model.TargetCoordinatesDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateTargetCoordinates {
    private final ProtocolManagerFactory protocolManagerFactory;

    public CalculateTargetCoordinates(ProtocolManagerFactory protocolManagerFactory) {
        this.protocolManagerFactory = protocolManagerFactory;
    }

    public TargetCoordinatesDto execute(CalculateTargetCoordinatesCommand command) {
        List<Protocol> protocols = command.protocols();
        protocols.addFirst(new MaxTargetDistanceProtocol());

        ProtocolManager protocolManager = protocolManagerFactory.create(command.protocols());

        List<ScanDataTarget> selectedTargets = protocolManager.execute(command.scanDataTargets());
        handleErrors(selectedTargets);
        ScanDataTarget selectedTarget = selectedTargets.getFirst();
        return new TargetCoordinatesDto(selectedTarget.coordinates().getX(), selectedTarget.coordinates().getY());
    }

    private void handleErrors(List<ScanDataTarget> selectedTargets) {
        if (selectedTargets.isEmpty())
            throw new VisionException(VisionError.NO_TARGETS_FOUND);
    }


}
