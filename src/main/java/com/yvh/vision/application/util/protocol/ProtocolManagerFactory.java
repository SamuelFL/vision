package com.yvh.vision.application.util.protocol;

import com.yvh.vision.core.model.protocol.Protocol;
import com.yvh.vision.core.model.protocol.ProtocolManager;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProtocolManagerFactory {

    public ProtocolManager create(List<Protocol> protocols) {
        return new ProtocolManager(protocols);
    }
}
