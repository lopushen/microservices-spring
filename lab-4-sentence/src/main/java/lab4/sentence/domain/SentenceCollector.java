package lab4.sentence.domain;

import lab4.sentence.domain.Word;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by i.lopushen on 20/07/2016.
 */
public class SentenceCollector implements Collector<Map.Entry<Word.Role, Word>, StringBuilder, String> {
    @Override
    public Supplier<StringBuilder> supplier() {
        return StringBuilder::new;
    }

    @Override
    public BiConsumer<StringBuilder, Map.Entry<Word.Role, Word>> accumulator() {
        return (sb, entry)-> sb.append(entry.getValue().getWord()+" ");
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return StringBuilder::append;
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return StringBuilder::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>();
    }
}
