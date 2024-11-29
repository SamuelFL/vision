package com.yvh.vision.core.model;

public enum ProtocolName {
    CLOSEST_ENEMIES("closest_enemies"),
    FURTHEST_ENEMIES("furthest_enemies"),
    ASSIST_ALLIES("assist_allies"),
    AVOID_CROSSFIRE("avoid_crossfire"),
    PRIORITIZE_MECH("prioritize_mech"),
    AVOID_MECH("avoid_mech");

    public final String protocolRequestName;

    ProtocolName(String protocolRequestName) {
        this.protocolRequestName = protocolRequestName;
    }

    public static ProtocolName getEnum(String protocolRequestName) {
        try {
            return valueOf(ProtocolName.class, protocolRequestName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(protocolRequestName + " protocol is not a valid one.");
        }
    }
}
