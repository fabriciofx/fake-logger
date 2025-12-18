/*
 * SPDX-FileCopyrightText: Copyright (C) 2025 Fabrício Barros Cabral
 * SPDX-License-Identifier: MIT
 */
package com.github.fabriciofx.fake.logger;

import com.github.fabriciofx.fake.logger.formatter.NoFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.stream.Collectors;

/**
 * FakeHandler logger.
 *
 * <p>There is no thread-safety guarantee.
 *
 * @since 0.0.1
 */
@SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
public final class FakeHandler extends Handler {
    /**
     * Records.
     */
    private final List<LogRecord> records;

    /**
     * Ctor.
     */
    public FakeHandler() {
        this(new NoFormatter());
    }

    /**
     * Ctor.
     * @param formatter Formatter for log messages
     */
    public FakeHandler(final Formatter formatter) {
        this.setFormatter(formatter);
        this.records = new LinkedList<>();
    }

    @Override
    public void publish(final LogRecord record) {
        this.records.add(record);
    }

    @Override
    public void close() {
        // Intended empty.
    }

    @Override
    public void flush() {
        // Intended empty.
    }

    @Override
    public String toString() {
        final Formatter formatter = this.getFormatter();
        return this.records.stream().map(formatter::format)
            .collect(Collectors.joining());
    }
}
