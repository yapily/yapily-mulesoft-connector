package com.mulesoft.connectors.yapily.internal.operation.refinement;

import com.mulesoft.connectors.yapily.internal.operation.base.GetConsentBySingleAccessConsentOperationBase;
import org.mule.runtime.api.el.ExpressionLanguage;

/** Middle part of the Operation. Can be used by the user to add custom code into the operation. */
public class GetConsentBySingleAccessConsentOperationRefinement
    extends GetConsentBySingleAccessConsentOperationBase {
  public GetConsentBySingleAccessConsentOperationRefinement(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetConsentBySingleAccessConsentOperationRefinement() {
    super();
  }
}
