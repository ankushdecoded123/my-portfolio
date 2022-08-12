package com.portfolio.ankush.controller;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.portfolio.ankush.model.Response;
import com.portfolio.ankush.model.WebMessage;

@Controller
public class PortfolioController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioController.class);

	private static final String HOMEPAGE = "index";

	@GetMapping("/")
	public String homepage() {
		return HOMEPAGE;
	}

	@GetMapping("/home")
	public String home() {
		return HOMEPAGE;
	}

	@GetMapping("/index")
	public String receive(Model model) {
		model.addAttribute("message", new WebMessage());
		return HOMEPAGE;
	}

	@PostMapping(value="/receive-message")
	public ResponseEntity<Response> receiveMessage(@ModelAttribute WebMessage message, BindingResult result, Model model) {
		model.addAttribute("message", message);
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> future = db.collection("web-message").document(message.getEmail()).set(message);
		try {
			if(future.get().getUpdateTime() != null)
				return ResponseEntity.ok().body(new Response("response", "Request posted successfully"));
			else
				return ResponseEntity.internalServerError().body(new Response("response", "ON MAINTENANCE, please mail us your request"));
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.error("ERROR : {}", e.getMessage());
			Thread.currentThread().interrupt();
			return ResponseEntity.internalServerError().body(new Response("response", "Something went wrong, please mail us your request"));
		}

	}
}
