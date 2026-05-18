package pe.com.relari.employee.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.InputStream;

public class JsonConverter {

    private JsonConverter() {}

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .findAndRegisterModules()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static <T> T readJsonFromResource(String resourcePath, Class<T> type) throws IOException {
        try (InputStream is = JsonConverter.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IOException("Resource not found: " + resourcePath);
            }
            return MAPPER.readValue(is, type);
        }
    }

    public static <T> T readJson(String json, Class<T> type) throws IOException {
        return MAPPER.readValue(json, type);
    }

    public static String toJsonString(Object object) throws JsonProcessingException {
        return MAPPER.writeValueAsString(object);
    }
}
