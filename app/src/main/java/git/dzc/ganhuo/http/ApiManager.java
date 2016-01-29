package git.dzc.ganhuo.http;

import android.util.Log;

import java.io.IOException;

import git.dzc.ganhuo.module.DayResult;
import git.dzc.ganhuo.module.NewsResult;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;

/**
 * Created by dzc on 16/1/28.
 */
public class ApiManager {
    String BASE_URL = "http://gank.avosapps.com/api/";

    private static ApiService apiService;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    public ApiManager() {

        okHttpClient = new OkHttpClient.Builder().addInterceptor(chain -> {
            Log.d("url",chain.request().url().toString());
            return chain.proceed(chain.request());
        }).build();
        retrofit = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).client(okHttpClient).validateEagerly(true).build();
        apiService = retrofit.create(ApiService.class);
    }

    public Observable<NewsResult> getNewsData(String type, int size, int page){
        return apiService.getData(type,size,page);
    }

    public Observable<DayResult> getDayData(int year,int month,int day){
        return apiService.getDayDay(year, month, day);
    }
}
