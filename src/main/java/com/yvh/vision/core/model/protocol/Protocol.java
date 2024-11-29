package com.yvh.vision.core.model.protocol;

import com.yvh.vision.core.model.ScanDataTarget;

import java.util.List;

@FunctionalInterface
public interface Protocol {
    List<ScanDataTarget> apply(List<ScanDataTarget> targets);
}
