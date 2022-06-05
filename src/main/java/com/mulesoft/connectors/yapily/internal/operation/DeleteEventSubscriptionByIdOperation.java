package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.DeleteEventSubscriptionByIdOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.DeleteEventSubscriptionByIdOperationRefinement;
import java.io.InputStream;
import org.mule.runtime.api.el.ExpressionLanguage;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.metadata.OutputResolver;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;

/** Lower part of the Operation. It has the operation declaration with its annotations. */
public class DeleteEventSubscriptionByIdOperation
    extends DeleteEventSubscriptionByIdOperationRefinement {
  public DeleteEventSubscriptionByIdOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public DeleteEventSubscriptionByIdOperation() {
    super();
  }

  /**
   * delete a event subscription within the data matching the id in the path
   *
   * <p>This operation makes an HTTP DELETE request to the
   * /notifications/event-subscriptions/{eventTypeId} endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param eventTypeIdUriParam Event type Id
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Delete Event Subscription By Id")
  @Summary("delete a event subscription within the data matching the id in the path")
  @MediaType("application/json")
  @OutputResolver(
      output = DeleteEventSubscriptionByIdOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void deleteEventSubscriptionById(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @DisplayName("Event Type Id") @Summary("Event type Id") String eventTypeIdUriParam,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.deleteEventSubscriptionById(
        config, connection, eventTypeIdUriParam, parameters, overrides, callback);
  }
}
