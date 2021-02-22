package org.lvtinger.paladin.web.core;

public class PaladinThreadLocal extends ThreadLocal<String> {
    private PaladinThreadLocal() {
    }

    public static PaladinThreadLocal getInstance() {
        return PaladinThreadLocalHolder.get();
    }

    private static class PaladinThreadLocalHolder {
        private static final PaladinThreadLocal threadLocal = new PaladinThreadLocal();

        public static PaladinThreadLocal get() {
            return threadLocal;
        }
    }
}
