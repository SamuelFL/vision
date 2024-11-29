package com.yvh.vision.web.rest;

import com.yvh.vision.application.commands.CalculateTargetCoordinatesCommand;
import com.yvh.vision.application.usecases.CalculateTargetCoordinates;
import com.yvh.vision.web.rest.api.RadarApi;
import com.yvh.vision.web.rest.converter.ProtocolConverter;
import com.yvh.vision.web.rest.converter.ScanConverter;
import com.yvh.vision.web.rest.model.TargetCoordinatesDto;
import com.yvh.vision.web.rest.model.VisionScanRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class TargetSelectorController implements RadarApi {

    private final CalculateTargetCoordinates calculateTargetCoordinates;

    private final ScanConverter scanConverter;
    private final ProtocolConverter protocolConverter;

    public TargetSelectorController(CalculateTargetCoordinates calculateTargetCoordinates,
                                    ScanConverter scanConverter, ProtocolConverter protocolConverter) {
        this.calculateTargetCoordinates = calculateTargetCoordinates;
        this.scanConverter = scanConverter;
        this.protocolConverter = protocolConverter;
    }

    @Override
    public ResponseEntity<TargetCoordinatesDto> getTargetCoordinates(VisionScanRequestDto visionScanRequestDto) {
        CalculateTargetCoordinatesCommand command = new CalculateTargetCoordinatesCommand(
                protocolConverter.toEntity(visionScanRequestDto.getProtocols()),
                scanConverter.toEntity(visionScanRequestDto.getScan()));
        return ResponseEntity.ok(calculateTargetCoordinates.execute(command));
    }
}