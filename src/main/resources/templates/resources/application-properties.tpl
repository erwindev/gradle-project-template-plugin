server.port=8999

# PostgreSQL
# spring.datasource.driverClassName=org.postgresql.Driver
# spring.datasource.url=jdbc:postgresql://localhost:5432/example
# spring.datasource.username=<user>
# spring.datasource.password=<password>
# spring.datasource.initial-size=10
# spring.datasource.max-active=30
# spring.datasource.connection-test-query=SELECT 1
# spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

# H2
spring.datasource.url=jdbc:h2:mem:example
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver

#create-drop will drop the table after the session
#validate will check the schema against existing tables
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true

#spring.thymeleaf.cache=false
#logging.level.com.erwindev:DEBUG

${projectName}.api_version = local

#logging.level.com.zaxxer.hikari=DEBUG

info.app.name=Starter Template API
info.app.description=Provides examples and standards for our microservice REST API projects.
info.app.version=1.0.0
info.app.contact=your@email.com

flyway.enabled=true
flyway.schemas=example