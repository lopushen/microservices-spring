package lab4.sentence.domain;

import java.util.TreeMap;

/**
 * Created by i.lopushen on 20/07/2016.
 */
public class Sentence {

    private TreeMap<Word.Role, Word> wordTreeMap = new TreeMap<>();

    public void addWord(Word word) {
        wordTreeMap.put(word.getRole(), word);
    }

    public String getSentence() {
        return wordTreeMap.entrySet().stream().collect(new SentenceCollector());
    }

}
