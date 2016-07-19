package lab4.sentence.service;

import lab4.sentence.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by i.lopushen on 19/07/2016.
 */
@Service
public class SentenceServiceImpl implements SentenceService {

    AdjectiveDao adjectiveDao;

    ArticleDao articleDao;

    NounDao nounDao;

    SubjectDao subjectDao;

    VerDao verDao;


    public String buildSentence() {
        return String.format("%s %s %s %s %s.", subjectDao.getSubject(), verDao.getVerb(), articleDao.getArticle(), adjectiveDao.getAdjective(), nounDao.getNoun());
    }

    @Autowired
    public void setAdjectiveDao(AdjectiveDao adjectiveDao) {
        this.adjectiveDao = adjectiveDao;
    }

    @Autowired
    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Autowired
    public void setNounDao(NounDao nounDao) {
        this.nounDao = nounDao;
    }

    @Autowired
    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Autowired
    public void setVerDao(VerDao verDao) {
        this.verDao = verDao;
    }
}
