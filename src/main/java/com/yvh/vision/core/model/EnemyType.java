package com.yvh.vision.core.model;

public enum EnemyType {
    MECH("mech"),
    SOLDIER("soldier");

    public final String enemyName;

    EnemyType(String enemyName) {
        this.enemyName = enemyName;
    }

    public static EnemyType getEnum(String enemyName) {
        try {
            return valueOf(EnemyType.class, enemyName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("'" + enemyName + "' enemy type is not valid");
        }
    }
}
