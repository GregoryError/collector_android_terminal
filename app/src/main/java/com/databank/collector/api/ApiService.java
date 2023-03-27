package com.databank.collector.api;

import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    // @GetMapping("/getAllParams")
    // @PostMapping("/saveReport")
    // public @ResponseBody ResponseEntity<String> saveReport(@RequestBody Map<String, Object> payload) {


    @GET("getAllParams")
    Call<JsonObject> getAllParams();
}
