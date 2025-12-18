/*
 * SPDX-FileCopyrightText: Copyright (C) 2025 Fabrício Barros Cabral
 * SPDX-License-Identifier: MIT
 */
package com.github.fabriciofx.fake.logger.formatter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * CustomFormatter.
 *
 * Custom format for log messages.
 *
 * @since 0.0.1
 */
public final class CustomFormatter extends Formatter {
    /**
     * Format.
     */
    private final String fmt;

    /**
     * Ctor.
     */
    public CustomFormatter() {
        this("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL %2$-7s %3$-80s %4$s%n");
    }

    /**
     * Ctor.
     * @param fmt Message format.
     */
    public CustomFormatter(final String fmt) {
        super();
        this.fmt = fmt;
    }

    @Override
    public String format(final LogRecord rcd) {
        final ZonedDateTime zdt = ZonedDateTime.ofInstant(
            rcd.getInstant(),
            ZoneId.systemDefault()
        );
        final String source;
        final String klass = rcd.getSourceClassName();
        final String method = rcd.getSourceMethodName();
        if (klass != null) {
            if (method != null) {
                source = String.format("%s::%s", klass, method);
            } else {
                source = klass;
            }
        } else {
            source = "";
        }
        return String.format(
            this.fmt,
            zdt,
            rcd.getLevel().getName(),
            source,
            rcd.getMessage()
        );
    }
}
