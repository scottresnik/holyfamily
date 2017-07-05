package org.holyfamily.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;
import java.util.List;

/**
 * Properties specific to JHipster.
 * <p>
 * Properties are configured in the application.yml file.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    private List<String> authorizedDomains;

    @Valid
    public List<String> getAuthorizedDomains() {
        return authorizedDomains;
    }

    public void setAuthorizedDomains(List<String> authorizedDomains) {
        this.authorizedDomains = authorizedDomains;
    }
}
