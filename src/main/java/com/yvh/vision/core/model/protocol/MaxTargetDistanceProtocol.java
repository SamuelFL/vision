package com.yvh.vision.core.model.protocol;

import com.yvh.vision.core.model.ScanDataTarget;
import com.yvh.vision.core.model.util.Constants;

import java.util.List;
import java.util.stream.Collectors;

public class MaxTargetDistanceProtocol implements Protocol {
    @Override
    public List<ScanDataTarget> apply(List<ScanDataTarget> targets) {
        return targets.stream().filter(this::isTargetTooFar)
                .collect(Collectors.toList());
    }

    private boolean isTargetTooFar(ScanDataTarget target) {
        return target.coordinates().getX().compareTo(Constants.MAX_TARGET_DISTANCE) < 0 ||
                target.coordinates().getY().compareTo(Constants.MAX_TARGET_DISTANCE) < 0;
    }

}
