package producer.recourse;

import producer.ProducerConfiguration;
import producer.model.Customer;
import producer.service.KafkaProducerService;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/kafka")
@Produces(MediaType.APPLICATION_JSON)
public class ProducerRecourse {

    private final KafkaProducerService kafkaProducerService;

    @Inject
    public ProducerRecourse(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;

    }

    @POST
    @Path("/message/{topicName}")
    public String sendMessageToTopic(@PathParam("topicName") String topicName, Customer customer) {

        kafkaProducerService.sendMessageToTopic(topicName, customer);

        return "success";
    }
}
