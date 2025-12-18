/*
 * SPDX-FileCopyrightText: Copyright (C) 2025 Fabrício Barros Cabral
 * SPDX-License-Identifier: MIT
 */
package com.github.fabriciofx.fake.logger;

import com.github.fabriciofx.fake.logger.formatter.CustomFormatter;
import com.github.fabriciofx.fake.logger.formatter.LeveledFormatter;
import com.github.fabriciofx.fake.logger.formatter.NoFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * FakeLogger tests.
 *
 * @since 0.0.1
 */
final class FakeLoggerTest {
    @Test
    void testLogNoFormattedMessages() {
        final Logger logger = new FakeLogger(
            new FakeHandler(
                new NoFormatter()
            )
        );
        logger.log(Level.INFO, "message #01");
        logger.log(Level.WARNING, "message #02");
        logger.log(Level.SEVERE, "message #03");
        Assertions.assertLinesMatch(
            List.of(
                "^message #01$",
                "^message #02$",
                "^message #03$"
            ),
            logger.toString().lines().toList()
        );
    }

    @Test
    void testLogLeveledMessages() {
        final Logger logger = new FakeLogger(
            new FakeHandler(
                new LeveledFormatter()
            )
        );
        logger.log(Level.INFO, "message #01");
        logger.log(Level.WARNING, "message #02");
        logger.log(Level.SEVERE, "message #03");
        Assertions.assertLinesMatch(
            List.of(
                "^INFO\\s+message #01$",
                "^WARNING\\s+message #02$",
                "^SEVERE\\s+message #03$"
            ),
            logger.toString().lines().toList()
        );
    }

    @Test
    void testLogCustomMessages() {
        final Logger logger = new FakeLogger(
            new FakeHandler(
                new CustomFormatter()
            )
        );
        logger.log(Level.INFO, "message #01");
        logger.log(Level.WARNING, "message #02");
        logger.log(Level.SEVERE, "message #03");
        Assertions.assertLinesMatch(
            List.of(
                "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3}\\s+INFO\\s+message #01$",
                "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3}\\s+WARNING\\s+message #02$",
                "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3}\\s+SEVERE\\s+message #03$"
            ),
            logger.toString().lines().toList()
        );
    }
}
