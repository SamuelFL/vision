package com.yvh.vision.core.model;

import com.yvh.vision.web.rest.model.ScanCoordinatesDto;

public record ScanDataTarget(ScanCoordinatesDto coordinates, Target target, Long allies) {
}
