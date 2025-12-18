/*
 * SPDX-FileCopyrightText: Copyright (C) 2025 Fabrício Barros Cabral
 * SPDX-License-Identifier: MIT
 */
package com.github.fabriciofx.fake.logger.formatter;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * NoFormatter.
 *
 * No format for log messages.
 *
 * @since 0.0.1
 */
public final class NoFormatter extends Formatter {
    @Override
    public String format(final LogRecord rcd) {
        return String.format("%1$s%n", rcd.getMessage());
    }
}
