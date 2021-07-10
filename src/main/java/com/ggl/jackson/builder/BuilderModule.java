package com.ggl.jackson.builder;

import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(fluent = true, chain = true)
public class BuilderModule extends SimpleModule {
  private static final String DEFAULT_BUILDER_METHOD_NAME = "builder";
  private static final String DEFAULT_BUILD_METHOD_NAME = "build";
  private static final String DEFAULT_PREFIX = "";

  private String builderMethodName;
  private String buildMethodName;
  private String withPrefix;

  public BuilderModule() {
    builderMethodName = DEFAULT_BUILDER_METHOD_NAME;
    buildMethodName = DEFAULT_BUILD_METHOD_NAME;
    withPrefix = DEFAULT_PREFIX;
  }

  @Override
  public void setupModule(final SetupContext context) {
    super.setupModule(context);
    context.appendAnnotationIntrospector(new BuilderAnnotationIntrospector(builderMethodName, buildMethodName, withPrefix));
  }
}
