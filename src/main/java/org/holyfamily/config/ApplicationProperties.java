package org.holyfamily.config;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;
import java.util.List;

/**
 * Properties specific to Holyfamily.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    private List<String> authorizedDomains;

    @Valid
    @NotEmpty
    public List<String> getAuthorizedDomains() {
        return authorizedDomains;
    }

    public void setAuthorizedDomains(List<String> authorizedDomains) {
        this.authorizedDomains = authorizedDomains;
    }
}
