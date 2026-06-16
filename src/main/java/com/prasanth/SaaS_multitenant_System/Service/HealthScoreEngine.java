package com.prasanth.SaaS_multitenant_System.Service;

import org.springframework.stereotype.Component;

@Component
public class HealthScoreEngine {
    public Integer calculateScore(
            Integer progress,
            Integer teamMembers,
            Integer pendingTasks) {

        return progress +
                (teamMembers * 5)
                - (pendingTasks * 3);
    }
}
