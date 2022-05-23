package com.mulesoft.connectors.yapily.internal.operation.refinement;

import com.mulesoft.connectors.yapily.internal.operation.base.CreatePreAuthorisationRequestOperationBase;
import org.mule.runtime.api.el.ExpressionLanguage;

/** Middle part of the Operation. Can be used by the user to add custom code into the operation. */
public class CreatePreAuthorisationRequestOperationRefinement
    extends CreatePreAuthorisationRequestOperationBase {
  public CreatePreAuthorisationRequestOperationRefinement(ExpressionLanguage arg0) {
    super(arg0);
  }

  public CreatePreAuthorisationRequestOperationRefinement() {
    super();
  }
}
