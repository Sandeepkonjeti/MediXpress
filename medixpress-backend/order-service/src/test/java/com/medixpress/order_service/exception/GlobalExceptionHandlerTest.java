package com.medixpress.order_service.exception;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ExceptionTestController.class)
class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHandleRuntimeException() throws Exception {
        mockMvc.perform(get("/test/runtime"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("This is a runtime exception"));
    }

    @Test
    void testHandleMedixpressException() throws Exception {
        mockMvc.perform(get("/test/medixpress"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("This is a custom Medixpress exception"));
    }

    @Test
    void testHandleGenericException() throws Exception {
        mockMvc.perform(get("/test/generic"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Something went wrong! Please try again."));
    }
}

@RestController
class ExceptionTestController {

    @GetMapping("/test/runtime")
    public void throwRuntime() {
        throw new RuntimeException("This is a runtime exception");
    }

    @GetMapping("/test/medixpress")
    public void throwMedixpress() {
        throw new CartEmptyException("This is a custom Medixpress exception");
    }

    @GetMapping("/test/generic")
    public void throwGeneric() throws Exception {
        throw new Exception("Generic exception");
    }
}

