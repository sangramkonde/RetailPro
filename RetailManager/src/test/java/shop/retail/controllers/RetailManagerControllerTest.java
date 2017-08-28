package shop.retail.controllers;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import shop.retail.ApplicationLauncher;
import shop.retail.BaseTest;
import shop.retail.RetailMessages;

import org.junit.runners.MethodSorters;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Locale;

/**
 * @author Sangram
 *
 */
/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = RetailShopController.class)
@AutoConfigureMockMvc*/
//extends BaseTest 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationLauncher.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RetailManagerControllerTest{

	/*@Autowired
	private MockMvc mockMvc;

	@Test
	public void checkStatus() throws Exception {
		this.mockMvc
				.perform(get("/shop/").header("Accept-Language",Locale.getDefault())).andDo(print())
				.andExpect(status().isOk()).andExpect(result -> {
					result.toString().equals(RetailMessages.SUCCESS);
				});
	}*/
	
	
   private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void getAllShop() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/shop").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(0))).andDo(print());
	}
}
