package com.eldermoraes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
@ApplicationScoped
public class ReadinessCheck implements HealthCheck {

    @Inject
    @RestClient
    TimeService timeService;

    @Override
    public HealthCheckResponse call() {
        try {
            timeService.getTime();
            return HealthCheckResponse.up("router is ready!");
        } catch (Exception e) {
            return HealthCheckResponse.up("router isn't ready...");
        }
    }
    
}