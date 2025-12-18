/*
 * SPDX-FileCopyrightText: Copyright (C) 2025 Fabrício Barros Cabral
 * SPDX-License-Identifier: MIT
 */
package com.github.fabriciofx.fake.logger;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FakeLogger.
 *
 * <p>There is no thread-safety guarantee.
 *
 * @since 0.0.1
 */
@SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
public final class FakeLogger extends Logger {
    /**
     * Ctor.
     */
    public FakeLogger() {
        this(new FakeHandler());
    }

    /**
     * Ctor.
     * @param handler Logger handler
     */
    public FakeLogger(final Handler handler) {
        this("FakeLogger", handler);
    }

    /**
     * Ctor.
     * @param name Logger name
     * @param handler Logger handler
     */
    public FakeLogger(final String name, final Handler handler) {
        this(name, handler, Level.INFO);
    }

    /**
     * Ctor.
     * @param name Logger name
     * @param handler Logger handler
     * @param lvl Logging level
     */
    public FakeLogger(
        final String name,
        final Handler handler,
        final Level lvl
    ) {
        super(name, null);
        this.setUseParentHandlers(false);
        this.addHandler(handler);
        this.setLevel(lvl);
    }

    @Override
    public String toString() {
        final Handler[] handlers = this.getHandlers();
        final String out;
        if (handlers.length > 0) {
            out = handlers[0].toString();
        } else {
            out = "(no handlers)";
        }
        return out;
    }
}
