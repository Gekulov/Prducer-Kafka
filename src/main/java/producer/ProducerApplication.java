package producer;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import producer.recourse.ProducerRecourse;
import producer.service.KafkaProducerService;

public class ProducerApplication extends Application<ProducerConfiguration> {


    public static void main(String[] args) throws Exception {
        new ProducerApplication().run(args);
    }

    @Override
    public String getName() {
        return "Producer";
    }


    @Override
    public void initialize(final Bootstrap<ProducerConfiguration> bootstrap) {

    }

    @Override
    public void run(ProducerConfiguration producerConfiguration, Environment environment) throws Exception {

        KafkaProducerService service = new KafkaProducerService(producerConfiguration.getProducer());
        environment.lifecycle().manage(service);
        environment.jersey().register(service);
        environment.jersey().register(ProducerRecourse.class);
    }

}
