package com.brillio.twelvefactorapp.healthcheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator{

	@Override
	public Health health() {
		boolean error = true;
		if(error){
		    return Health.down().withDetail("Error Key","Server is interuppted").outOfService().build();
		}
		return Health.up().build();
	}

}
