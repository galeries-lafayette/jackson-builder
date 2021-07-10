package com.ggl.jackson.builder;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class BuilderAnnotationIntrospector extends JacksonAnnotationIntrospector {
  private final String builderMethodName;
  private final String buildMethodName;
  private final String withPrefix;

  @Override
  public JsonPOJOBuilder.Value findPOJOBuilderConfig(final AnnotatedClass ac) {
    return ac.hasAnnotation(JsonPOJOBuilder.class) ?
      super.findPOJOBuilderConfig(ac) :
      new JsonPOJOBuilder.Value(buildMethodName, withPrefix);
  }

  @Override
  public Class<?> findPOJOBuilder(final AnnotatedClass ac) {
    return Optional.<Class<?>>ofNullable(super.findPOJOBuilder(ac))
      .or(() ->
        ac.getFactoryMethods()
          .stream()
          .filter(method -> method.getName().equals(builderMethodName))
          .findAny()
          .map(AnnotatedMethod::getRawReturnType)
      )
      .orElse(null);
  }

}
