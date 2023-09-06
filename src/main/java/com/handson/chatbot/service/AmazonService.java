package com.handson.chatbot.service;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AmazonService {

    public String searchProducts(String keyword) {
        return "Searched for:" + keyword;
    }
    private String getProductHtml(String keyword) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://www.amazon.com/s?i=aps&k=ipod&ref=nb_sb_noss&url=search-alias%3Daps")
                .method("GET", body)
                .addHeader("authority", "www.amazon.com")
                .addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .addHeader("accept-language", "en-US,en;q=0.9")
                .addHeader("cookie", "aws-ubid-main=141-3677424-7760543; aws-account-alias=995553441267; remember-account=false; aws-userInfo=%7B%22arn%22%3A%22arn%3Aaws%3Aiam%3A%3A995553441267%3Auser%2Fmaayanj%22%2C%22alias%22%3A%22995553441267%22%2C%22username%22%3A%22maayanj%22%2C%22keybase%22%3A%22nVXfCGiwcBBYJmWFEzsZt0gji4xiPCTLxBLXnPnfjj8%5Cu003d%22%2C%22issuer%22%3A%22http%3A%2F%2Fsignin.aws.amazon.com%2Fsignin%22%2C%22signinType%22%3A%22PUBLIC%22%7D; aws-userInfo-signed=eyJ0eXAiOiJKV1MiLCJrZXlSZWdpb24iOiJ1cy1lYXN0LTIiLCJhbGciOiJFUzM4NCIsImtpZCI6IjU1MWQxODhiLWI3NGItNGNhMi05ZjY1LWY1YjdhZjIyNTVhMCJ9.eyJzdWIiOiI5OTU1NTM0NDEyNjciLCJzaWduaW5UeXBlIjoiUFVCTElDIiwiaXNzIjoiaHR0cDpcL1wvc2lnbmluLmF3cy5hbWF6b24uY29tXC9zaWduaW4iLCJrZXliYXNlIjoiblZYZkNHaXdjQkJZSm1XRkV6c1p0MGdqaTR4aVBDVEx4QkxYblBuZmpqOD0iLCJhcm4iOiJhcm46YXdzOmlhbTo6OTk1NTUzNDQxMjY3OnVzZXJcL21hYXlhbmoiLCJ1c2VybmFtZSI6Im1hYXlhbmoifQ.K3-d1o5uBMBs7BItn2F1hTX9Dio6nq0baljpJV1Nnu-I9FPfHML7trXyrN7bErCaYeZX5_2RTB8TPelkpBs0xl5r6X4pEVArKxfpjVMa177m0N69aWfO_dgftJOkg3Gh; regStatus=registered; noflush_awsccs_sid=600ad48fed17adb4f79504b8445d739bead5ab922e91e9ab90bc69e397111623; aws-signer-token_eu-north-1=eyJrZXlWZXJzaW9uIjoiY3ZSblRkWDUxR0ZxeDdNTkNENG9rbnVaT3FwdDBEQmgiLCJ2YWx1ZSI6IkV6UUZCUVllb1hjR01IbVJHNG9ZRCsyd3RkQUsvZWdHN2dBV1pJYmpMVEk9IiwidmVyc2lvbiI6MX0=; session-id=140-2087831-4285329; session-id-time=2082787201l; i18n-prefs=USD; skin=noskin; ubid-main=131-8838412-2513726; session-token=Qa6MAJdFSvKcmfx4Mr7yXnmFgN+i/QhJW4y5AIUSvbmdQwEXLoWVEHhXp2Bdhw1VRbQK5ZxAPWxrTli1n3sj8bG82ySL85Q6Iq5TJKzHD1AzKewpnOxDqS74Zn9cxiPxUKQlt8VXiqXT8WRbAISmV8WHE+C5njJdXTJVhDPWEyMdhW2HLI1H9VR5ElY8jGH/H0fOy66mBD+8rzmtb0PFyczZA+6dxaREel6R5Z4vmUnol+HiWCpWfcnTk0r94se2QsIWEu/yQxW1k1JqFubQ6f+6MHNEi8EPrYWylnYQ7CPnTy8tZfcQi3pETR96HKDECS/MYpY/to62ANLbK+J7ENJhzyAmDVpD; csm-hit=tb:0YV94SM97Z4YDSC1X0EW+b-0YV94SM97Z4YDSC1X0EW|1694041737180&t:1694041737180&adb:adblk_no")
                .addHeader("device-memory", "8")
                .addHeader("downlink", "3")
                .addHeader("dpr", "1")
                .addHeader("ect", "4g")
                .addHeader("referer", "https://www.amazon.com/s?k=ipod&ref=nb_sb_noss")
                .addHeader("rtt", "50")
                .addHeader("sec-ch-device-memory", "8")
                .addHeader("sec-ch-dpr", "1")
                .addHeader("sec-ch-ua", "\"Not_A Brand\";v=\"99\", \"Google Chrome\";v=\"109\", \"Chromium\";v=\"109\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Linux\"")
                .addHeader("sec-ch-viewport-width", "748")
                .addHeader("sec-fetch-dest", "document")
                .addHeader("sec-fetch-mode", "navigate")
                .addHeader("sec-fetch-site", "same-origin")
                .addHeader("sec-fetch-user", "?1")
                .addHeader("upgrade-insecure-requests", "1")
                .addHeader("user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36")
                .addHeader("viewport-width", "748")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}