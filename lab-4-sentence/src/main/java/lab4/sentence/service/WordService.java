package lab4.sentence.service;

import lab4.sentence.domain.Word;
import rx.Observable;

/**
 * Created by i.lopushen on 19/07/2016.
 */
public interface WordService {

    Observable<Word> getAdjective();
    Observable<Word> getArticle();
    Observable<Word> getNoun();
    Observable<Word> getSubject();
    Observable<Word> getVerb();
}
