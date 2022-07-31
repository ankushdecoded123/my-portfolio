package com.portfolio.ankush.config;

import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;


@Component
public class FirebaseInitialize {

	private static final Logger LOGGER = LoggerFactory.getLogger(FirebaseInitialize.class);
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Value( "${firebase.datasource.url}" )
	private String firbaseDatasourceUrl;
	
	@PostConstruct
	public void initialize() {
		final Resource fileResource = resourceLoader.getResource("classpath:firebase-service.json");
		try (InputStream serviceAccount =
				fileResource.getInputStream()){
					FirebaseOptions options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
					  .setDatabaseUrl(firbaseDatasourceUrl)
					  .build();

					FirebaseApp.initializeApp(options);
			        FirestoreClient.getFirestore();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}
}
