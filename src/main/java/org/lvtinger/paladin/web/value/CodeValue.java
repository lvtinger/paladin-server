package org.lvtinger.paladin.web.value;

import lombok.Data;

import java.io.Serializable;

@Data
public class CodeValue implements Serializable {
    private static final long serialVersionUID = -6876777203495264997L;
    private String mobile;
    private Integer code;
}
