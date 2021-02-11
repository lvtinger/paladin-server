package org.lvtinger.paladin.relation.api.enums;

public enum RelationType {
    friend(1), stranger(2), blacklist(3);
    public final int value;

    RelationType(int value) {
        this.value = value;
    }
}
