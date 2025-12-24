package ma.emsi.microservicecommandes.health;

import ma.emsi.microservicecommandes.services.CommandeService;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CommandeHealthIndicator implements HealthIndicator {

    private final CommandeService service;

    public CommandeHealthIndicator(CommandeService service) {
        this.service = service;
    }

    @Override
    public Health health() {
        long nb = service.count();
        return Health.up().withDetail("commandes_count", nb).build();
    }
}
