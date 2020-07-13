package it.euris.springtest;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.euris.testspringejb.JsonPlaceholderService;

@SpringBootTest
class SpringTestApplicationTests {

	@Test
	void contextLoads() throws IOException {
		JsonPlaceholderService s = new JsonPlaceholderService();
		s.getPost(1);
	}

}
