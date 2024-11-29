package com.yvh.vision.core.model.util;

import com.yvh.vision.core.model.ScanDataTarget;

import java.math.BigDecimal;
import java.math.MathContext;

public class ComparatorUtils {
    private ComparatorUtils() {
    }

    /*
        TODO BigDecimal precission is being lost here, sqrt full precision method to be created.
        */
    public static BigDecimal distance(ScanDataTarget target) {
        MathContext mathContext = new MathContext(Constants.DECIMAL_PRECISSION_DIGITS);
        return BigDecimal.valueOf(Math.sqrt(
                target.coordinates().getX().pow(2, mathContext)
                        .add(target.coordinates().getX().pow(2, mathContext)).doubleValue()));
    }
}
