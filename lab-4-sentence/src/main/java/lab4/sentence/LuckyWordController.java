package lab4.sentence;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by i.lopushen on 21/07/2016.
 */
@RestController
@ConfigurationProperties(prefix = "wordConfig")
public class LuckyWordController {
    private String luckyWord;
    @RequestMapping("/lucky-word")
    public String getLuckyWord() {
        return luckyWord;
    }

    public void setLuckyWord(String luckyWord) {
        this.luckyWord = luckyWord;
    }
}
