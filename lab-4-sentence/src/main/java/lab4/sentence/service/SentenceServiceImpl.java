package lab4.sentence.service;

import lab4.sentence.domain.Sentence;
import lab4.sentence.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by i.lopushen on 19/07/2016.
 */
@Service
public class SentenceServiceImpl implements SentenceService {

    @Autowired
    WordService wordService;


    public String buildSentence() {
        Sentence sentence = new Sentence();
        List<Observable<Word>> observables = createObservables();
        CountDownLatch latch = new CountDownLatch(observables.size());
        Observable.merge(observables).subscribe(word -> {
            sentence.addWord(word);
            latch.countDown();
        });
        waitForAll(latch);
        return sentence.getSentence();
    }

    private List<Observable<Word>> createObservables() {
        List<Observable<Word>> observables = new ArrayList<>();
        Observable<Word> subject = wordService.getSubject();
        observables.add(subject);
        Observable<Word> verb = wordService.getVerb();
        observables.add(verb);
        Observable<Word> article = wordService.getArticle();
        observables.add(article);
        Observable<Word> adjective = wordService.getAdjective();
        observables.add(adjective);
        Observable<Word> noun = wordService.getNoun();
        observables.add(noun);

        return observables;
    }

    private void waitForAll(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
