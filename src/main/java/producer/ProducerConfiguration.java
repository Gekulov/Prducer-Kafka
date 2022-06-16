package producer;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ProducerConfiguration extends Configuration {
    @NotNull
    @Valid
    @JsonProperty("topics")
    private List<String> topics;

    @JsonProperty("producer")
    private ProdConfig producer;

    public List<String> getTopics() {
        return topics;
    }

    public ProdConfig getProducer() {
        return producer;
    }


//    public String getServers() {
//        return servers;
//    }
//
//    public String getKey() {
//        return key;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public List<String> getTopics() {
//        return topics;
//    }
//
//    public void setTopics(List<String> topics) {
//        this.topics = topics;
//    }

}
