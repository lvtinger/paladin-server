package org.lvtinger.paladin.relation.api.enums;

public enum RelationExecuteType {
    establish(1), severance(2);

    public final int value;

    RelationExecuteType(int value) {
        this.value = value;
    }
}
