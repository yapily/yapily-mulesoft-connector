package com.mulesoft.connectors.yapily.internal.extension;

import com.mulesoft.connectivity.rest.commons.api.error.RestError;
import com.mulesoft.connectors.yapily.internal.config.YapilyConfiguration;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.runtime.extension.api.annotation.error.ErrorTypes;
import org.mule.runtime.extension.api.annotation.license.RequiresEnterpriseLicense;

@Extension(name = "Yapily")
@Xml(prefix = "yapily")
@Configurations({YapilyConfiguration.class})
@ErrorTypes(RestError.class)
@RequiresEnterpriseLicense(allowEvaluationLicense = true)
public class Yapily {
  public static final String API_METADATA_CATEGORY = "Yapily";
}
