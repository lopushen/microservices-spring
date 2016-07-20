package lab4.sentence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by i.lopushen on 19/07/2016.
 */
@Service
public class SentenceServiceImpl implements SentenceService {

    @Autowired
    WordService wordService;


    public String buildSentence() {
        return String.format("%s %s %s %s %s.", wordService.getSubject(), wordService.getVerb(), wordService.getArticle(), wordService.getAdjective(), wordService.getNoun());
    }

}
