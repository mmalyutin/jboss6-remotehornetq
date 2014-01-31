import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.ActivationConfigProperty;
import org.jboss.ejb3.annotation.ResourceAdapter;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@MessageDriven(name = "MessageConsumerBean",
               activationConfig =
                     {
                        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/testqueue"),
                        @ActivationConfigProperty(propertyName = "providerAdapterJNDI", propertyValue = "java:/HornetQJMSProvider"),
                        @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "1"),
                     })
@ResourceAdapter("hornetq-ra.rar")
public class MessageConsumerBean implements MessageListener {

    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
                System.out.println("Reading message: " + msg.getText());
            } else {
                System.out.println("Message is not a TextMessage");
            }
        } catch (JMSException e) {
            throw new IllegalStateException(e);
        }
    }
}
