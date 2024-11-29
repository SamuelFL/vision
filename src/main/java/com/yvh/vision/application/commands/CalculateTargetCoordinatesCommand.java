package com.yvh.vision.application.commands;

import com.yvh.vision.application.util.Validator;
import com.yvh.vision.core.model.ScanDataTarget;
import com.yvh.vision.core.model.protocol.Protocol;

import java.util.List;

public record CalculateTargetCoordinatesCommand(List<Protocol> protocols,
                                                List<ScanDataTarget> scanDataTargets) {


    public CalculateTargetCoordinatesCommand(List<Protocol> protocols, List<ScanDataTarget> scanDataTargets) {
        this.protocols = protocols;
        this.scanDataTargets = scanDataTargets;
        validate();
    }

    private void validate() {
        Validator.notEmpty(protocols, "protocols");
        Validator.notEmpty(scanDataTargets, "scan");
    }
}
