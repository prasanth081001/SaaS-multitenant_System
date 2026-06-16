package com.prasanth.SaaS_multitenant_System.Service;

import org.springframework.stereotype.Component;

@Component
public class RiskPredictionEngine {
    public String calculateRisk(
            Integer progress,
            Integer daysRemaining) {

        if (progress < 30 &&
                daysRemaining < 7) {

            return "HIGH";
        }

        if (progress < 60) {
            return "MEDIUM";
        }

        return "LOW";
    }
}
