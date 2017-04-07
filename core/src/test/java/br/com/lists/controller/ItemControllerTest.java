package br.com.lists.controller;

import br.com.lists.ListServiceApplicationTest;
import br.com.lists.request.ItemRequest;
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
public class ItemControllerTest {

    @Autowired
    private ItemController itemController;

    @Test
    public void getItemsByListId() throws Exception {
    }

    @Test
    public void itemById() throws Exception {
    }

    @Test
    public void list() throws Exception {

        given().standaloneSetup(itemController)
                .contentType(ContentType.JSON)
                .when()
                .get("/lists/29f539a9-78bd-430d-8108-96e9c1f845ce/items?user_id=254b7c4a-5ce6-405c-b6a2-01ed7dbbe937&token=1")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void listById() throws Exception {

        given().standaloneSetup(itemController)
                .contentType(ContentType.JSON)
                .when()
                .get("/lists/29f539a9-78bd-430d-8108-96e9c1f845ce/items/618efc6b-b3dc-47aa-8faa-4ba1ae0bc52d?user_id=254b7c4a-5ce6-405c-b6a2-01ed7dbbe937&token=1")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void save() throws Exception {
        given().standaloneSetup(itemController)
                .contentType(ContentType.JSON)
                .body(ItemRequest.builder().name("Lista").quantity(1).isMarkedAsCheck(false).build())
                .when()
                .post("/lists/29f539a9-78bd-430d-8108-96e9c1f845ce/items?user_id=254b7c4a-5ce6-405c-b6a2-01ed7dbbe937&token=1")
                .then()
                .assertThat()
                .statusCode(201)
                .body("id", not(IsNull.nullValue()));
    }

    @Test
    public void update() throws Exception {

        given().standaloneSetup(itemController)
                .contentType(ContentType.JSON)
                .body(ItemRequest.builder().name("Lista").quantity(1).isMarkedAsCheck(false).build())
                .when()
                .post("/lists/29f539a9-78bd-430d-8108-96e9c1f845ce/items?user_id=254b7c4a-5ce6-405c-b6a2-01ed7dbbe937&token=1")
                .then()
                .assertThat()
                .statusCode(201)
                .body("id", not(IsNull.nullValue()));
    }

    @Test
    public void synchronize() throws Exception {
        given().standaloneSetup(itemController)
                .contentType(ContentType.JSON)
                .body(Collections.singletonList(ItemRequest.builder().name("Lista").quantity(1).isMarkedAsCheck(false).build()))
                .when()
                .post("/lists/29f539a9-78bd-430d-8108-96e9c1f845ce/items/synchronize?user_id=254b7c4a-5ce6-405c-b6a2-01ed7dbbe937&token=1")
                .then()
                .assertThat()
                .statusCode(200);
    }

}