package com.yvh.vision.core.model.protocol;

import com.yvh.vision.core.model.ScanDataTarget;
import com.yvh.vision.core.model.util.ComparatorUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FurthestEnemiesProtocol implements Protocol {
    @Override
    public List<ScanDataTarget> apply(List<ScanDataTarget> scanDataTargets) {
        return scanDataTargets.stream().sorted(
                        Comparator.comparing(ComparatorUtils::distance))
                .collect(Collectors.toList());
    }
}
