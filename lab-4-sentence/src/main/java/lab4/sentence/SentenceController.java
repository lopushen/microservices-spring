package lab4.sentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Created by i.lopushen on 12/07/2016.
 */
@RestController
public class SentenceController {

    @Autowired
    private LoadBalancerClient client;

    @RequestMapping("/sentence")
    public
    @ResponseBody
    String getSentence() {
        return
                getWord("LAB-4-SUBJECT") + " "
                        + getWord("LAB-4-VERB") + " "
                        + getWord("LAB-4-ARTICLE") + " "
                        + getWord("LAB-4-ADJECTIVE") + " "
                        + getWord("LAB-4-NOUN") + "."
                ;
    }

    public String getWord(String service) {
        ServiceInstance serviceInstance = client.choose(service);
        if (serviceInstance != null) {
            return (new RestTemplate()).getForObject(serviceInstance.getUri(), String.class);
        }
        return null;
    }
}
