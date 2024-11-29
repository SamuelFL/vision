package com.yvh.vision.core.model.protocol;

import com.yvh.vision.core.model.ScanDataTarget;

import java.util.List;
import java.util.stream.Collectors;

public class AssistAlliesProtocol implements Protocol {
    @Override
    public List<ScanDataTarget> apply(List<ScanDataTarget> scanDataTargets) {
        return scanDataTargets.stream()
                .filter(scanDataTarget -> scanDataTarget.allies() > 0L)
                .collect(Collectors.toList());
    }
}
