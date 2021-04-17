package com.nar.bimito.presentation.splash.main.model;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppVersionPresentationMapperImp_Factory implements Factory<AppVersionPresentationMapperImp> {
  @Override
  public AppVersionPresentationMapperImp get() {
    return newInstance();
  }

  public static AppVersionPresentationMapperImp_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AppVersionPresentationMapperImp newInstance() {
    return new AppVersionPresentationMapperImp();
  }

  private static final class InstanceHolder {
    private static final AppVersionPresentationMapperImp_Factory INSTANCE = new AppVersionPresentationMapperImp_Factory();
  }
}
