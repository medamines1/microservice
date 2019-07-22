package service;

import main.FcmSettings;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class FcmClient {

    public FcmClient(FcmSettings settings) {
        Path p = Paths.get(settings.getServiceAccountFile());
        try (InputStream serviceAccount = Files.newInputStream(p)) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

            FirebaseApp.initializeApp(options);
        }
        catch (IOException e) {
           log.error("init fcm", e);
        }
    }

    public void send(Map<String, String> data,String topic,String background_body , String title)
            throws InterruptedException, ExecutionException {

        Message message = Message.builder().putAllData(data).setTopic(topic)
                .setWebpushConfig(WebpushConfig.builder().putHeader("ttl", "300")
                        .setNotification(new WebpushNotification(title,
                                background_body, "mail2.png"))
                        .build())
                .build();

        String response = FirebaseMessaging.getInstance().sendAsync(message).get();
        System.out.println("Sent message: " + response + " to Topic : " + topic);
    }


    public void subscribe(String topic, String clientToken) {
        try {
            TopicManagementResponse response = FirebaseMessaging.getInstance()
                    .subscribeToTopicAsync(Collections.singletonList(clientToken), topic).get();
            System.out
                    .println(response.getSuccessCount() + " tokens were subscribed successfully");
        }
        catch (InterruptedException | ExecutionException e) {
            log.error("subscribe", e);
        }
    }
}
