package com.yvh.vision.core.model.protocol;

import com.yvh.vision.core.model.ScanDataTarget;

import java.util.List;

public class ProtocolManager {
    private final List<Protocol> protocols;

    public ProtocolManager(List<Protocol> protocols) {
        this.protocols = protocols;
    }

    public List<ScanDataTarget> execute(List<ScanDataTarget> targets) {
        List<ScanDataTarget> result = targets;
        for (Protocol protocol : protocols) {
            result = protocol.apply(result);
        }
        return result;
    }
}
