package lab4.sentence.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.ObservableResult;
import lab4.sentence.dao.*;
import lab4.sentence.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rx.Observable;

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
    public Observable<Word> getAdjective() {
        return new ObservableResult<Word>() {
            @Override
            public Word invoke() {
                return new Word(adjectiveDao.getAdjective().getWord(), Word.Role.ADJECTIVE);
            }
        };
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallBackArticle")
    public Observable<Word> getArticle() {
        return new ObservableResult<Word>() {
            @Override
            public Word invoke() {
                return new Word(articleDao.getArticle().getWord(), Word.Role.ARTICLE);
            }
        };
    }

    @HystrixCommand(fallbackMethod = "getFallBackNoun")
    @Override
    public Observable<Word> getNoun() {
        return new ObservableResult<Word>() {
            @Override
            public Word invoke() {
                return new Word(nounDao.getNoun().getWord(), Word.Role.NOUN);
            }
        };
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallBackSubject")
    public Observable<Word> getSubject() {
        return new ObservableResult<Word>() {
            @Override
            public Word invoke() {
                return new Word(subjectDao.getSubject().getWord(), Word.Role.SUBJECT);
            }
        };
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallBackVerb")
    public Observable<Word> getVerb() {
        return new ObservableResult<Word>() {
            @Override
            public Word invoke() {
                return new Word(verDao.getVerb().getWord(), Word.Role.VERB);
            }
        };
    }

    @SuppressWarnings(value = "unused")
    public Word getFallBackAdjective() {

        return new Word("", Word.Role.ADJECTIVE);

    }

    @SuppressWarnings(value = "unused")
    public Word getFallBackSubject() {
        return new Word("someone", Word.Role.SUBJECT);
    }

    @SuppressWarnings(value = "unused")
    public Word getFallBackVerb() {
        return new Word("did", Word.Role.VERB);
    }

    @SuppressWarnings(value = "unused")
    public Word getFallBackNoun() {
        return new Word("something", Word.Role.NOUN);
    }

    @SuppressWarnings(value = "unused")
    public Word getFallBackArticle() {
        return new Word("a/the", Word.Role.ARTICLE);
    }
}
