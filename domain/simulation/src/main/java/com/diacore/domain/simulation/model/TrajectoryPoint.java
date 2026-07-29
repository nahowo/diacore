package com.diacore.domain.simulation.model;

public record TrajectoryPoint(
        int offsetMinutes,
        Integer iobPred,
        Integer cobPred,
        Integer zeroTempPred,
        Integer uamPred,
        Integer simulatedPred
) {}
