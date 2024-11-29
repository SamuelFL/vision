package com.yvh.vision.core.model.protocol;

import com.yvh.vision.core.model.EnemyType;
import com.yvh.vision.core.model.ScanDataTarget;

import java.util.List;
import java.util.stream.Collectors;

public class PrioritizeMechProtocol implements Protocol {
    @Override
    public List<ScanDataTarget> apply(List<ScanDataTarget> scanDataTargets) {
        if (mechsPresent(scanDataTargets)) {
            return scanDataTargets.stream()
                    .filter(scanDataTarget -> scanDataTarget.target().enemyType().equals(EnemyType.MECH))
                    .collect(Collectors.toList());
        }
        return scanDataTargets;
    }

    private boolean mechsPresent(List<ScanDataTarget> scanDataTargets) {
        return scanDataTargets.stream().anyMatch(
                scanDataTarget -> scanDataTarget.target().enemyType().equals(EnemyType.MECH));
    }
}
