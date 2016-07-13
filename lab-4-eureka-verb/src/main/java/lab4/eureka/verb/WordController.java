package lab4.eureka.verb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by i.lopushen on 12/07/2016.
 */
@RestController
public class WordController {

    @Value("${words}")
    private String words;

    @RequestMapping("/")
    public String getWord() {
        String[] wordArray = words.split(",");
        int i = (int)Math.round(Math.random() * (wordArray.length - 1));
        return wordArray[i];
    }
}
