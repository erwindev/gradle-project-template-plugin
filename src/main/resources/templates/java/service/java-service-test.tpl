package ${classPackage}.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import ${classPackage}.service.${serviceName};

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

	@Autowired
	${serviceName} service;

	@Test
	public void whoAmIShouldReturnMessageFromService() throws Exception{
		assertEquals(service.whoAmI(), "I AM GROOT!");
	}
}