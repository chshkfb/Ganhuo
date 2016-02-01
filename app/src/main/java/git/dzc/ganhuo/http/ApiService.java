package git.dzc.ganhuo.http;

import git.dzc.ganhuo.module.NewsResult;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by dzc on 16/1/28.
 */
public interface ApiService {

    @GET("data/{type}/{size}/{page}")
    Observable<NewsResult> getData(
            @Path("type") String type,
            @Path("size") int size,
            @Path("page") int page);


}
