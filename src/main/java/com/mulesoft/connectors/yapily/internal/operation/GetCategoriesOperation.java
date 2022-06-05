package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.GetCategoriesOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.GetCategoriesOperationRefinement;
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
public class GetCategoriesOperation extends GetCategoriesOperationRefinement {
  public GetCategoriesOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetCategoriesOperation() {
    super();
  }

  /**
   * Used to retrieve the list of categories returned by the Yapily Categorisation engine for a
   * given locale. <br>
   * <br>
   * See [Data
   * Enrichment](https://docs.yapily.com/pages/key-concepts/account-data/data-enrichment/intro-to-data-enrichment/)
   * for more information.
   *
   * <p>This operation makes an HTTP GET request to the /categories/{country} endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param countryUriParam __Mandatory__. The 2 letter country code e.g. 'GB'.
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Get Categories")
  @Summary(
      "Used to retrieve the list of categories returned by the Yapily Categorisation engine for a given locale. <br><br>See [Data Enrichment](https://docs.yapily.com/pages/key-concepts/account-data/data-enrichment/intro-to-data-enrichment/) for more information.")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = GetCategoriesOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void getCategories(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @DisplayName("country") @Summary("__Mandatory__. The 2 letter country code e.g. 'GB'.")
          String countryUriParam,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.getCategories(config, connection, countryUriParam, parameters, overrides, callback);
  }
}
