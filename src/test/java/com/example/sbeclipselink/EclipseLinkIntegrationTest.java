package com.example.sbeclipselink;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
public class EclipseLinkIntegrationTest {

    @Autowired
    private ApplicationContext context;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
        assertNotNull(context);
        assertNotNull(entityManager);
        assertNotNull(dataSource);

        // Verify that EclipseLink is being used
        String providerName = entityManager.getEntityManagerFactory().getProperties()
                .get("jakarta.persistence.provider").toString();
        System.out.println("[DEBUG_LOG] JPA Provider: " + providerName);

        assertEquals("org.eclipse.persistence.jpa.PersistenceProvider", providerName);
    }
}
