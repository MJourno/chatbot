package com.handson.chatbot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service

public class JokesService {
    OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
    @Autowired
    ObjectMapper om;
//    public String searchJokes(String keyword) throws IOException {
//        return getJokeData(getJokeId(keyword));
//    }
//    public Response getJokeData (String jokeId) throws IOException{
//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = RequestBody.create(mediaType, "");
//        Request request = new Request.Builder()
//                .url("https://api.chucknorris.io/jokes/" + jokeId +"")
//                .method("GET", body)
//                .build();
//        Response response = client.newCall(request).execute();
////        return response;
//        JokeData res = om.readValue(response.body().string(), JokeData.class);
//        return res.getData.getJokes().get(0).getText();
//    }
    public String getJokeId(String keyword) throws IOException {

//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = RequestBody.create(mediaType, "");
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.chucknorris.io/jokes/search?query=" + keyword + "")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        JokesResponse res = om.readValue(response.body().string(), JokesResponse.class);
//        String jokeId = res.getResult().get(0).getId();
                return res.getResult().get(0).getId();
//        return Integer.parseInt(jokeId);
//        Response response = client.newCall(request).execute();
//        return response.body().string();
    }

    static class JokesResponse {
        List<JokesObject> result;

        public List<JokesObject> getResult() {
            return result;
        }
    }
    static class JokesObject {
        String id;

        public String getId() {
            return id;
        }
    }



    //second call


}
