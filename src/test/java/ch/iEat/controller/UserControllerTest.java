package ch.iEat.controller;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class UserControllerTest {
	 

	    private MockMvc mockMvc;
	    

	    @Before
	    public void setup() {
	        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	        
	    }

	    
	    @Test
	    public void testGetAccount() throws Exception {
	        this.mockMvc.perform(get("/user-account.jsp"))
         .andExpect(status().is4xxClientError());
	        
	    }
	    


}
