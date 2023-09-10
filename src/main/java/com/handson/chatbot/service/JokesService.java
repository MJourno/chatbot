package com.handson.chatbot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    public String searchJokes(String keyword) throws IOException {
        return getJokeId(keyword);
    }

    public String getJokeId(String keyword) throws IOException {
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.chucknorris.io/jokes/search?query=" + keyword + "")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        JokesResponse res = om.readValue(response.body().string(), JokesResponse.class);
                return res.getResult().get(0).getValue();

    }

    static class JokesResponse {
        List<JokesObject> result;

        public List<JokesObject> getResult() {
            return result;
        }
    }
    static class JokesObject {
        String value;

        public String getValue() {
            return value;
        }

    }

}
