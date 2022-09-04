package com.rvalessandro.springmicroserviceboilerplate.foundation.configs.data;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.stereotype.Component;

@Component
public class MultiSchemaFlywayMigrations implements FlywayMigrationStrategy {

    @Override
    public void migrate(Flyway flyway) {
        var dataSource = flyway.getConfiguration().getDataSource();
        for(TenantsEnum tenant : TenantsEnum.values()) {
            Flyway.configure()
                    .schemas(tenant.name())
                    .locations("db/migration")
                    .dataSource(dataSource).load()
                    .migrate()
            ;
        }
    }
}
