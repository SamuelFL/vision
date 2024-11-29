package com.yvh.vision.core.model.protocol;

import com.yvh.vision.core.model.ScanDataTarget;
import com.yvh.vision.core.model.util.ComparatorUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ClosestEnemiesProtocol implements Protocol {
    @Override
    public List<ScanDataTarget> apply(List<ScanDataTarget> scanDataTargets) {
        return scanDataTargets.stream().sorted(
                        (o1, o2) ->
                                ComparatorUtils.distance(o2).compareTo(ComparatorUtils.distance(o1)))
                .collect(Collectors.toList());
    }
}
