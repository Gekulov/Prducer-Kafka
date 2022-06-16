import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class KafkaProducerApplication extends Application<KafkaProducerConfiguration> {

    public static void main(String[] args) throws Exception{
    new KafkaProducerApplication().run(args);
    }

    @Override
    public void run(KafkaProducerConfiguration kafkaProducerConfiguration, Environment environment) throws Exception {

    }
}
