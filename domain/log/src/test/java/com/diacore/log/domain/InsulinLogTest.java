package com.diacore.log.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.diacore.domain.log.model.InsulinLog;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InsulinLogTest {
    @Test
    @DisplayName("Throw IllegalArgumentException when insulin dose is less then 0")
    void create_fail_when_dose_is_zero_or_less() {
        Long userId = 1L;
        OffsetDateTime now = OffsetDateTime.now();
        Float invalidDose = 0.0F;
        String type = "FAST_ACTING";

        assertThatThrownBy(() -> InsulinLog.create(userId, now, invalidDose, type))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Insulin dose must be over 0. ");
    }

    @Test
    @DisplayName("create Insulin dose log")
    void create_success() {
        Long userId = 1L;
        OffsetDateTime now = OffsetDateTime.now();
        Float validDose = 5.0F;
        String type = "LONG_ACTING";

        InsulinLog log = InsulinLog.create(userId, now, validDose, type);

        assertThat(log.getUserId()).isEqualTo(userId);
        assertThat(log.getDose()).isEqualTo(validDose);
    }
}
