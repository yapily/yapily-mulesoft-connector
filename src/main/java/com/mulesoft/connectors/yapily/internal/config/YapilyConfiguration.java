package com.mulesoft.connectors.yapily.internal.config;

import com.mulesoft.connectors.yapily.internal.config.refinement.YapilyConfigurationRefinement;
import com.mulesoft.connectors.yapily.internal.connection.provider.BasicAuthConnectionProvider;
import com.mulesoft.connectors.yapily.internal.operation.AddUserOperation;
import com.mulesoft.connectors.yapily.internal.operation.CreateBulkPaymentAuthorisationOperation;
import com.mulesoft.connectors.yapily.internal.operation.CreateBulkPaymentOperation;
import com.mulesoft.connectors.yapily.internal.operation.CreateConsentWithCodeOperation;
import com.mulesoft.connectors.yapily.internal.operation.CreateEmbeddedBulkPaymentAuthorisationOperation;
import com.mulesoft.connectors.yapily.internal.operation.CreateEmbeddedPaymentAuthorisationOperation;
import com.mulesoft.connectors.yapily.internal.operation.CreateEventSubscriptionOperation;
import com.mulesoft.connectors.yapily.internal.operation.CreatePaymentAuthorisationOperation;
import com.mulesoft.connectors.yapily.internal.operation.CreatePaymentOperation;
import com.mulesoft.connectors.yapily.internal.operation.CreatePaymentPreAuthorisationRequestOperation;
import com.mulesoft.connectors.yapily.internal.operation.CreatePreAuthorisationRequestOperation;
import com.mulesoft.connectors.yapily.internal.operation.CreateProfileConsentOperation;
import com.mulesoft.connectors.yapily.internal.operation.DeleteEventSubscriptionByIdOperation;
import com.mulesoft.connectors.yapily.internal.operation.DeleteOperation;
import com.mulesoft.connectors.yapily.internal.operation.DeleteProfileConsentOperation;
import com.mulesoft.connectors.yapily.internal.operation.DeleteUserOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetAccountBalancesOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetAccountDirectDebitsOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetAccountOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetAccountPeriodicPaymentsOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetAccountScheduledPaymentsOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetAccountsOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetApplicationMeOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetBeneficiariesOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetCategoriesOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetConsentByIdOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetConsentBySingleAccessConsentOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetConsentsOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetEventSubscriptionByIdOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetEventSubscriptionsOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetEventTypesOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetFeatureDetailsOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetIdentityOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetInstitutionOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetInstitutionsOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetPaymentsOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetProfileConsentOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetStatementFileOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetStatementOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetStatementsOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetTransactionsOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetUserOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetUserProfileOperation;
import com.mulesoft.connectors.yapily.internal.operation.GetUsersOperation;
import com.mulesoft.connectors.yapily.internal.operation.InitiateAccountRequestOperation;
import com.mulesoft.connectors.yapily.internal.operation.InitiateEmbeddedAccountRequestOperation;
import com.mulesoft.connectors.yapily.internal.operation.ReAuthoriseAccountOperation;
import com.mulesoft.connectors.yapily.internal.operation.UpdateEmbeddedAccountRequestOperation;
import com.mulesoft.connectors.yapily.internal.operation.UpdateEmbeddedBulkPaymentAuthorisationOperation;
import com.mulesoft.connectors.yapily.internal.operation.UpdateEmbeddedPaymentAuthorisationOperation;
import com.mulesoft.connectors.yapily.internal.operation.UpdatePaymentAuthorisationOperation;
import com.mulesoft.connectors.yapily.internal.operation.UpdatePreAuthoriseAccountConsentOperation;
import org.mule.runtime.extension.api.annotation.Configuration;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;

@Configuration
@Operations({
  ReAuthoriseAccountOperation.class,
  InitiateAccountRequestOperation.class,
  UpdatePreAuthoriseAccountConsentOperation.class,
  GetAccountsOperation.class,
  GetAccountOperation.class,
  GetAccountBalancesOperation.class,
  GetBeneficiariesOperation.class,
  GetAccountDirectDebitsOperation.class,
  GetAccountPeriodicPaymentsOperation.class,
  GetAccountScheduledPaymentsOperation.class,
  GetStatementsOperation.class,
  GetStatementOperation.class,
  GetStatementFileOperation.class,
  GetTransactionsOperation.class,
  CreateBulkPaymentAuthorisationOperation.class,
  CreateBulkPaymentOperation.class,
  GetCategoriesOperation.class,
  CreateConsentWithCodeOperation.class,
  GetConsentBySingleAccessConsentOperation.class,
  GetConsentsOperation.class,
  DeleteOperation.class,
  GetConsentByIdOperation.class,
  InitiateEmbeddedAccountRequestOperation.class,
  UpdateEmbeddedAccountRequestOperation.class,
  CreateEmbeddedBulkPaymentAuthorisationOperation.class,
  UpdateEmbeddedBulkPaymentAuthorisationOperation.class,
  CreateEmbeddedPaymentAuthorisationOperation.class,
  UpdateEmbeddedPaymentAuthorisationOperation.class,
  GetFeatureDetailsOperation.class,
  GetIdentityOperation.class,
  GetInstitutionsOperation.class,
  GetInstitutionOperation.class,
  GetApplicationMeOperation.class,
  CreatePaymentAuthorisationOperation.class,
  UpdatePaymentAuthorisationOperation.class,
  CreatePaymentOperation.class,
  GetPaymentsOperation.class,
  CreatePreAuthorisationRequestOperation.class,
  CreatePaymentPreAuthorisationRequestOperation.class,
  GetUsersOperation.class,
  AddUserOperation.class,
  DeleteUserOperation.class,
  GetUserOperation.class,
  CreateProfileConsentOperation.class,
  GetProfileConsentOperation.class,
  DeleteProfileConsentOperation.class,
  GetUserProfileOperation.class,
  GetEventTypesOperation.class,
  CreateEventSubscriptionOperation.class,
  GetEventSubscriptionsOperation.class,
  GetEventSubscriptionByIdOperation.class,
  DeleteEventSubscriptionByIdOperation.class
})
@ConnectionProviders({BasicAuthConnectionProvider.class})
public class YapilyConfiguration extends YapilyConfigurationRefinement {}
