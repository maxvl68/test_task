package com.example.test_spring.controller;

import com.example.test_spring.entity.Client;
import com.example.test_spring.entity.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TransactionControllerTest {

        @Autowired
        private TestRestTemplate restTemplate;

        @Value("http://localhost:${local.server.port}/${server.servlet.context-path}/transactions")
        private String appPath;

        private Transaction c1, c2, c3;

        @Before
        public void setUp() {

            Client client1 = Client.builder().idClient(1L).firstName("Ivan").lastName("Ivanoff").middleName("Ivanoff")
                    .inn("1234567890").build();
            Client client2 = Client.builder().idClient(2L).firstName("Ivan").lastName("Ivanoff").middleName("Ivanoff")
                    .inn("1234567890").build();
            Client client3 = Client.builder().idClient(3L).firstName("Ivan").lastName("Ivanoff").middleName("Ivanoff")
                    .inn("1234567890").build();

            this.c1 = Transaction.builder().id(1L).place("A PLACE 1").amount("10.01").currency("UAH")
                    .card("123456****1234").client(client1).build();
            this.c2 = Transaction.builder()
                    .id(2L).place("A PLACE 2").amount("9876.01").currency("UAH")
                    .card("123456****1234").client(client2).build();
            this.c3 = Transaction.builder()
                    .id(3L).place("A PLACE 3").amount("12.01").currency("USD")
                    .card("123456****1234").client(client3).build();
        }

        @Test
        public void allTransactionsTest() {

            var paramType = new ParameterizedTypeReference<List<Transaction>>() { };
            var transactions = restTemplate.exchange(appPath, HttpMethod.GET, null, paramType);

            assertThat(transactions.getBody()).hasSize(4);
            assertThat(transactions.getBody()).contains(this.c1, this.c2, this.c3);
        }

        @Test
        public void oneTransaction() {

            var transaction = this.restTemplate.getForObject(appPath + "/1/", Transaction.class);
            assertThat(transaction).extracting("place", "amount").containsExactly("A PLACE 1",
                    "10.01");
        }
}
