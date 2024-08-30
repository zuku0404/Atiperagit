package com.zukmateusz.atiperagit;

import com.zukmateusz.atiperagit.http_repo.GitHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class AtiperagitApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtiperagitApplication.class, args);
	}

	@Bean
	GitHttpClient gitHttpClient() {
		RestClient restClient = RestClient.builder().baseUrl("https://api.github.com/").build();
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(GitHttpClient.class);
	}
}
