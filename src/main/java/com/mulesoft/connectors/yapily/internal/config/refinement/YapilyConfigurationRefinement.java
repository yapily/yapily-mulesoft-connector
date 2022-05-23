package com.mulesoft.connectors.yapily.internal.config.refinement;

import com.mulesoft.connectors.yapily.internal.config.base.YapilyConfigurationBase;

/**
 * This refinement is the middle layer of the configuration generation gap pattern. It can be
 * overridden to add custom logic in the configuration.
 */
public abstract class YapilyConfigurationRefinement extends YapilyConfigurationBase {}
