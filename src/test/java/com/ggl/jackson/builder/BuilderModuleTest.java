package com.ggl.jackson.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class BuilderModuleTest {

  @Builder
  @Value
  private static class Pojo {
    @Default List<String> list = emptyList();
    String str;
  }

  @Test
  void should_deserialize_pojo() throws JsonProcessingException {
    // Given
    val objectMapper = new ObjectMapper().registerModule(new BuilderModule());
    val json = "{ \"str\": \"value\"}";

    // When
    val result = objectMapper.readValue(json, Pojo.class);

    // Then
    assertThat(result).isEqualTo(Pojo.builder().str("value").build());
    assertThat(result.list).isNotNull().isEmpty();
  }
}
