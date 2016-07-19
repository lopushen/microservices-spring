package lab4.sentence;

import lab4.sentence.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by i.lopushen on 12/07/2016.
 */
@RestController
public class SentenceController {

    @Autowired
    private SentenceService sentenceServiceImpl;

    @RequestMapping("/sentence")
    public String getSentence() {
        return sentenceServiceImpl.buildSentence();
    }
}
