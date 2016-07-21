package lab4.sentence.domain;

/**
 * Created by i.lopushen on 20/07/2016.
 */
public class Word {

    private String word;
    private Role role;

    public Word() {
    }

    public Word(String word) {
        this.word = word;
    }

    public Word(String word, Role role) {
        this.word = word;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getWord() {
        return word;
    }

    public enum Role {
        SUBJECT, VERB, ARTICLE, ADJECTIVE, NOUN;
    }
}
