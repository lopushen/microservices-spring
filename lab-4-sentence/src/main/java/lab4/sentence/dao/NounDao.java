package lab4.sentence.dao;

import lab4.sentence.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by i.lopushen on 19/07/2016.
 */
@FeignClient("NOUN")
public interface NounDao {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    Word getNoun();
}
