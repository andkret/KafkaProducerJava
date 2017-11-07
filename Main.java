import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Produce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		
		//put in the necessary properties to create the Kafka connection
		Properties props = new Properties();
		 props.put("bootstrap.servers", "localhost:9092");
		 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		 //Create a new Kakfa producer
		 Producer<String, String> producer = new KafkaProducer<>(props);
		 
		 for(int i = 0; i < 100; i++){
		     
			 //Create a random number
			 int  randomnumberone = rand.nextInt(50) + 1;
			 
			 //produce that random number to the test topic
		     producer.send(new ProducerRecord<String, String>("test", "btn1", "1," + Integer.toString(randomnumberone)));
		     
		 }
		 
		 producer.close();
		
		
	}

}
