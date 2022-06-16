package producer;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ProdConfig {
    @NotNull
    @Valid
    @JsonProperty("servers")
    private String servers;

    @NotNull
    @Valid
    @JsonProperty("key")
    private String key;

    @NotNull
    @Valid
    @JsonProperty("value")
    private String value;

    public String getServers() {
        return servers;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
