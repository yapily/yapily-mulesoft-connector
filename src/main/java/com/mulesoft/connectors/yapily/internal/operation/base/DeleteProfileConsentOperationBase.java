package com.mulesoft.connectors.yapily.internal.operation.base;

import com.mulesoft.connectivity.rest.commons.api.binding.HttpRequestBinding;
import com.mulesoft.connectivity.rest.commons.api.binding.HttpResponseBinding;
import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RestError;
import com.mulesoft.connectivity.rest.commons.api.operation.BaseRestOperation;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectivity.rest.commons.internal.util.RestRequestBuilder;
import com.mulesoft.connectivity.rest.commons.internal.util.StreamUtils;
import java.util.HashMap;
import java.util.Map;
import org.mule.runtime.api.el.ExpressionLanguage;
import org.mule.runtime.extension.api.exception.ModuleException;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;
import org.mule.runtime.http.api.HttpConstants;

/** Higher part of the Operation. It has the implementation of the operation. */
public abstract class DeleteProfileConsentOperationBase extends BaseRestOperation {
  protected static final String OPERATION_PATH =
      "/users/{userUuid}/profile/consents/{profileConsentId}";

  protected static final RestRequestBuilder.ParameterArrayFormat QUERY_PARAM_FORMAT =
      RestRequestBuilder.ParameterArrayFormat.MULTIMAP;

  public DeleteProfileConsentOperationBase(ExpressionLanguage arg0) {
    super(arg0);
  }

  public DeleteProfileConsentOperationBase() {
    super();
  }

  protected void deleteProfileConsent(
      RestConfiguration config,
      RestConnection connection,
      String userUuidUriParam,
      String profileConsentIdUriParam,
      RequestParameters parameters,
      ConfigurationOverrides overrides,
      CompletionCallback<Void, Void> callback) {
    try {
      Map<String, Object> customParameterBindings = new HashMap<>();
      deleteProfileConsentMain(
          config,
          connection,
          userUuidUriParam,
          profileConsentIdUriParam,
          customParameterBindings,
          parameters,
          overrides,
          callback);
    } catch (ModuleException e) {
      callback.error(e);
    } catch (Throwable e) {
      callback.error(new ModuleException("Unknown error", RestError.CONNECTIVITY, e));
    }
  }

  protected void deleteProfileConsentMain(
      RestConfiguration config,
      RestConnection connection,
      String userUuidUriParam,
      String profileConsentIdUriParam,
      Map<String, Object> customParameterBindings,
      RequestParameters parameters,
      ConfigurationOverrides overrides,
      CompletionCallback<Void, Void> callback) {
    Map<String, Object> parameterBindings = new HashMap<>();
    parameterBindings = StreamUtils.resolveCursorProvider(parameterBindings);
    customParameterBindings = StreamUtils.resolveCursorProvider(customParameterBindings);
    RestRequestBuilder builder =
        getRequestBuilderWithBindings(
                connection.getBaseUri(),
                OPERATION_PATH,
                HttpConstants.Method.DELETE,
                parameters,
                overrides,
                connection,
                config,
                parameterBindings,
                customParameterBindings)
            .setQueryParamFormat(QUERY_PARAM_FORMAT)
            .addUriParam("userUuid", userUuidUriParam)
            .addUriParam("profileConsentId", profileConsentIdUriParam);
    doVoidRequest(connection, builder, overrides.getResponseTimeoutAsMillis(), callback);
  }

  @Override
  protected String getRequestBodyMediaType() {
    return "application/json";
  }

  @Override
  protected String getResponseBodyMediaType() {
    return "application/json";
  }

  @Override
  protected HttpRequestBinding getRequestBindings() {
    HttpRequestBinding bindings = new HttpRequestBinding();
    return bindings;
  }

  @Override
  protected HttpResponseBinding getResponseBindings() {
    HttpResponseBinding bindings = new HttpResponseBinding();
    return bindings;
  }
}
