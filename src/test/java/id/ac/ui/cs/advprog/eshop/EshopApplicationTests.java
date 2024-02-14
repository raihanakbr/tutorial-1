package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EshopApplicationTests {

	@Test
	void contextLoads() {
		assertNotNull(EshopApplication.class);
	}
	@Test
	void mainMethodStartsApplication() {
		EshopApplication.main(new String[]{});
		assertNotNull(EshopApplication.class);
	}
}
