/*
 * SPDX-FileCopyrightText: Copyright (C) 2025 Fabrício Barros Cabral
 * SPDX-License-Identifier: MIT
 */
package com.github.fabriciofx.fake.logger.formatter;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * LeveledFormatter.
 *
 * Only level and message log format.
 *
 * @since 0.0.1
 */
public final class LeveledFormatter extends Formatter {
    @Override
    public String format(final LogRecord rcd) {
        return String.format(
            "%1$-7s %2$s%n",
            rcd.getLevel().getName(),
            rcd.getMessage()
        );
    }
}
