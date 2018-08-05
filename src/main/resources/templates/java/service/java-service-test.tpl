package ${classPackage}.service;

import static org.assertj.core.api.Assertions.assertThat;

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

	@TestConfiguration
	static class ServiceImplTestContextConfiguration {

        @Bean
        public ${serviceName} service() {
                return new ${serviceName}();
        }
	}

	@Autowired
	${serviceName} service

	@Test
	public void whoAmIShouldReturnMessageFromService() throws Exception{
		assertThat(service.whoAmI(), is("I AM GROOT"));
	}
}