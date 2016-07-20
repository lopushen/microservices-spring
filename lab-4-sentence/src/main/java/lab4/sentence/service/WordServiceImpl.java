package lab4.sentence.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lab4.sentence.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by i.lopushen on 19/07/2016.
 */
@Component
public class WordServiceImpl implements WordService {

    @Autowired
    AdjectiveDao adjectiveDao;

    @Autowired
    ArticleDao articleDao;

    @Autowired
    NounDao nounDao;

    @Autowired
    SubjectDao subjectDao;

    @Autowired
    VerbDao verDao;

    @Override
    @HystrixCommand(fallbackMethod = "getFallBackAdjective")
    public String getAdjective() {
        return adjectiveDao.getAdjective();
    }

    @Override
    public String getArticle() {
        return articleDao.getArticle();
    }

    @HystrixCommand(fallbackMethod = "getFallBackNoun")
    @Override
    public String getNoun() {
        return nounDao.getNoun();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallBackSubject")
    public String getSubject() {
        return subjectDao.getSubject();
    }

    @Override
    public String getVerb() {
        return verDao.getVerb();
    }

    @SuppressWarnings(value = "unused")
    public String getFallBackAdjective() {
        return "";
    }

    @SuppressWarnings(value = "unused")
    public String getFallBackSubject() {
        return "someone";
    }

    @SuppressWarnings(value = "unused")
    public String getFallBackNoun() {
        return "something";
    }
}
