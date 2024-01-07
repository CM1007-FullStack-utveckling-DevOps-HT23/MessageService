package cm1007.messageservice;

import cm1007.messageservice.ViewModels.MessageAnswerVM;
import cm1007.messageservice.ViewModels.MessageCreateVM;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockUser
	void testGetMessagesBySourceId() throws Exception {
		String userId = "-1";

		mockMvc.perform(MockMvcRequestBuilders.get("/message/source/{userId}", userId))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].id").exists())
				.andExpect(jsonPath("$[0].sourceUserId").exists())
				.andExpect(jsonPath("$[0].targetUserId").exists())
				.andExpect(jsonPath("$[0].message").exists());
	}

	@Test
	@WithMockUser
	void testGetMessagesByTargetId() throws Exception {
		String userId = "-2";

		mockMvc.perform(MockMvcRequestBuilders.get("/message/target/{userId}", userId))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].id").exists())
				.andExpect(jsonPath("$[0].sourceUserId").exists())
				.andExpect(jsonPath("$[0].targetUserId").exists())
				.andExpect(jsonPath("$[0].message").exists());
	}

	/*
	Kör utan write funktioner

	@Test
	@WithMockUser
	void testSendMessage() throws Exception {
		MessageCreateVM messageCreateVM = new MessageCreateVM();
		messageCreateVM.setSourceUserId("sourceUserId");
		messageCreateVM.setTargetUserId("targetUserId");
		messageCreateVM.setMessage("Test message");

		mockMvc.perform(MockMvcRequestBuilders.post("/message/send")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(messageCreateVM)))
				.andExpect(status().isOk())
				.andExpect(content().string("Message sent successfully!"));
	}

	@Test
	@WithMockUser
	void testAnswerMessage() throws Exception {
		Long messageId = 1L;
		MessageAnswerVM answer = new MessageAnswerVM();
		answer.setAnswer("Test answer");

		mockMvc.perform(MockMvcRequestBuilders.post("/message/answer/{messageId}", messageId)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(answer)))
				.andExpect(status().isOk())
				.andExpect(content().string("Message answered successfully!"));
	}
	 */
}