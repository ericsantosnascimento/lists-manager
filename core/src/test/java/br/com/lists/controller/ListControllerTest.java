package br.com.lists.controller;

import br.com.lists.ListServiceApplicationTest;
import br.com.lists.request.ListRequest;
import io.restassured.http.ContentType;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.not;

/**
 * Created by eric-nasc on 07/04/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ListServiceApplicationTest.class)
@ActiveProfiles("test")
@Transactional
public class ListControllerTest {

    @Autowired
    private ListController listController;

    @Test
    public void list() throws Exception {

        given().standaloneSetup(listController)
                .contentType(ContentType.JSON)
                .when()
                .get("/lists?user_id=254b7c4a-5ce6-405c-b6a2-01ed7dbbe937&token=1")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void listById() throws Exception {

        given().standaloneSetup(listController)
                .contentType(ContentType.JSON)
                .when()
                .get("/lists?user_id=254b7c4a-5ce6-405c-b6a2-01ed7dbbe937&token=1")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void save() throws Exception {
        given().standaloneSetup(listController)
                .contentType(ContentType.JSON)
                .body(ListRequest.builder().name("Lista").build())
                .when()
                .post("/lists?user_id=254b7c4a-5ce6-405c-b6a2-01ed7dbbe937&token=1")
                .then()
                .assertThat()
                .statusCode(201)
                .body("id", not(IsNull.nullValue()));
    }

    @Test
    public void update() throws Exception {

        given().standaloneSetup(listController)
                .contentType(ContentType.JSON)
                .body(ListRequest.builder().name("Lista").build())
                .when()
                .post("/lists?user_id=254b7c4a-5ce6-405c-b6a2-01ed7dbbe937&token=1")
                .then()
                .assertThat()
                .statusCode(201)
                .body("id", not(IsNull.nullValue()));
    }

    @Test
    public void synchronize() throws Exception {
        given().standaloneSetup(listController)
                .contentType(ContentType.JSON)
                .body(Collections.singletonList(ListRequest.builder().name("Lista").build()))
                .when()
                .post("/lists/synchronize?user_id=254b7c4a-5ce6-405c-b6a2-01ed7dbbe937&token=1")
                .then()
                .assertThat()
                .statusCode(200);
    }

}