package personal.ivan.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import personal.ivan.spring.requestMapping.RequestMapping;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(controllers = RequestMapping.class)
@RunWith(SpringRunner.class)
class RequestParamTest {

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new RequestMapping()).build();
    }

    @Test
    void requestParamTest() throws Exception {
        mockMvc.perform(get("/order2").param("id", "5"))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    void defaultRequestParamTest() throws Exception {
        mockMvc.perform(get("/order3"))
                .andExpect(status().isOk()).andDo(print());
    }

}