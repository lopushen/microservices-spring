package lab4.sentence.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by i.lopushen on 19/07/2016.
 */
@FeignClient("ARTICLE")
public interface ArticleDao {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getArticle();
}
