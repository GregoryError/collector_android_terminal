package com.databank.collector.api;

import com.databank.collector.Report;
import com.google.gson.JsonObject;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    // @GetMapping("/getAllParams")
    // @PostMapping("/saveReport")
    // public @ResponseBody ResponseEntity<String> saveReport(@RequestBody Map<String, Object> payload) {


    @GET("getAllParams")
    Call<JsonObject> getAllParams();

    @POST("saveReport")
    Call<JsonObject> sendParams(@Body Report report);
}
