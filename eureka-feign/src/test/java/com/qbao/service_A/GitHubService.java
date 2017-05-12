package com.qbao.service_A;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubService {
  @GET("api-a/add")
  Call<Integer> listRepos(@Query("a") String a,@Query("b") String b,@Query("accessToken") String accessToken);
}