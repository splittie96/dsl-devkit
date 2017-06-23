/*
 * generated by Xtext
 */
package com.avaloq.tools.ddk.xtext.export.serializer;

import com.avaloq.tools.ddk.xtext.export.export.Attribute;
import com.avaloq.tools.ddk.xtext.export.export.Export;
import com.avaloq.tools.ddk.xtext.export.export.ExportModel;
import com.avaloq.tools.ddk.xtext.export.export.ExportPackage;
import com.avaloq.tools.ddk.xtext.export.export.Extension;
import com.avaloq.tools.ddk.xtext.export.export.Import;
import com.avaloq.tools.ddk.xtext.export.export.Interface;
import com.avaloq.tools.ddk.xtext.export.export.InterfaceExpression;
import com.avaloq.tools.ddk.xtext.export.export.InterfaceField;
import com.avaloq.tools.ddk.xtext.export.export.InterfaceNavigation;
import com.avaloq.tools.ddk.xtext.export.export.UserData;
import com.avaloq.tools.ddk.xtext.export.services.ExportGrammarAccess;
import com.avaloq.tools.ddk.xtext.expression.expression.BooleanLiteral;
import com.avaloq.tools.ddk.xtext.expression.expression.BooleanOperation;
import com.avaloq.tools.ddk.xtext.expression.expression.Case;
import com.avaloq.tools.ddk.xtext.expression.expression.CastedExpression;
import com.avaloq.tools.ddk.xtext.expression.expression.ChainExpression;
import com.avaloq.tools.ddk.xtext.expression.expression.CollectionExpression;
import com.avaloq.tools.ddk.xtext.expression.expression.ConstructorCallExpression;
import com.avaloq.tools.ddk.xtext.expression.expression.ExpressionPackage;
import com.avaloq.tools.ddk.xtext.expression.expression.FeatureCall;
import com.avaloq.tools.ddk.xtext.expression.expression.GlobalVarExpression;
import com.avaloq.tools.ddk.xtext.expression.expression.Identifier;
import com.avaloq.tools.ddk.xtext.expression.expression.IfExpression;
import com.avaloq.tools.ddk.xtext.expression.expression.IntegerLiteral;
import com.avaloq.tools.ddk.xtext.expression.expression.LetExpression;
import com.avaloq.tools.ddk.xtext.expression.expression.ListLiteral;
import com.avaloq.tools.ddk.xtext.expression.expression.NullLiteral;
import com.avaloq.tools.ddk.xtext.expression.expression.OperationCall;
import com.avaloq.tools.ddk.xtext.expression.expression.RealLiteral;
import com.avaloq.tools.ddk.xtext.expression.expression.StringLiteral;
import com.avaloq.tools.ddk.xtext.expression.expression.SwitchExpression;
import com.avaloq.tools.ddk.xtext.expression.expression.TypeSelectExpression;
import com.avaloq.tools.ddk.xtext.expression.serializer.ExpressionSemanticSequencer;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractExportSemanticSequencer extends ExpressionSemanticSequencer {

  @Inject
  private ExportGrammarAccess grammarAccess;

  @Override
  public void createSequence(EObject context, EObject semanticObject) {
  	if(semanticObject.eClass().getEPackage() == ExportPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
  		case ExportPackage.ATTRIBUTE:
  			sequence_Attribute(context, (Attribute) semanticObject); 
  			return; 
  		case ExportPackage.EXPORT:
  			sequence_Export(context, (Export) semanticObject); 
  			return; 
  		case ExportPackage.EXPORT_MODEL:
  			sequence_ExportModel(context, (ExportModel) semanticObject); 
  			return; 
  		case ExportPackage.EXTENSION:
  			sequence_Extension(context, (Extension) semanticObject); 
  			return; 
  		case ExportPackage.IMPORT:
  			sequence_Import(context, (Import) semanticObject); 
  			return; 
  		case ExportPackage.INTERFACE:
  			sequence_Interface(context, (Interface) semanticObject); 
  			return; 
  		case ExportPackage.INTERFACE_EXPRESSION:
  			sequence_InterfaceExpression(context, (InterfaceExpression) semanticObject); 
  			return; 
  		case ExportPackage.INTERFACE_FIELD:
  			sequence_InterfaceField(context, (InterfaceField) semanticObject); 
  			return; 
  		case ExportPackage.INTERFACE_NAVIGATION:
  			sequence_InterfaceNavigation(context, (InterfaceNavigation) semanticObject); 
  			return; 
  		case ExportPackage.USER_DATA:
  			sequence_UserData(context, (UserData) semanticObject); 
  			return; 
  		}
  	else if(semanticObject.eClass().getEPackage() == ExpressionPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
  		case ExpressionPackage.BOOLEAN_LITERAL:
  			sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
  			return; 
  		case ExpressionPackage.BOOLEAN_OPERATION:
  			sequence_AndExpression_ImpliesExpression_OrExpression_RelationalExpression(context, (BooleanOperation) semanticObject); 
  			return; 
  		case ExpressionPackage.CASE:
  			sequence_Case(context, (Case) semanticObject); 
  			return; 
  		case ExpressionPackage.CASTED_EXPRESSION:
  			sequence_CastedExpression(context, (CastedExpression) semanticObject); 
  			return; 
  		case ExpressionPackage.CHAIN_EXPRESSION:
  			sequence_ChainExpression(context, (ChainExpression) semanticObject); 
  			return; 
  		case ExpressionPackage.COLLECTION_EXPRESSION:
  			if(context == grammarAccess.getCollectionExpressionRule() ||
  			   context == grammarAccess.getFeatureCallRule()) {
  				sequence_CollectionExpression(context, (CollectionExpression) semanticObject); 
  				return; 
  			}
  			else if(context == grammarAccess.getAdditiveExpressionRule() ||
  			   context == grammarAccess.getAdditiveExpressionAccess().getOperationCallParamsAction_1_0() ||
  			   context == grammarAccess.getAndExpressionRule() ||
  			   context == grammarAccess.getAndExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getChainExpressionRule() ||
  			   context == grammarAccess.getChainExpressionAccess().getChainExpressionFirstAction_1_0() ||
  			   context == grammarAccess.getChainedExpressionRule() ||
  			   context == grammarAccess.getExpressionRule() ||
  			   context == grammarAccess.getIfExpressionTriRule() ||
  			   context == grammarAccess.getIfExpressionTriAccess().getIfExpressionConditionAction_1_0() ||
  			   context == grammarAccess.getImpliesExpressionRule() ||
  			   context == grammarAccess.getImpliesExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getInfixExpressionRule() ||
  			   context == grammarAccess.getInfixExpressionAccess().getCollectionExpressionTargetAction_1_3_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getFeatureCallTargetAction_1_1_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getOperationCallTargetAction_1_0_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getTypeSelectExpressionTargetAction_1_2_0() ||
  			   context == grammarAccess.getMultiplicativeExpressionRule() ||
  			   context == grammarAccess.getMultiplicativeExpressionAccess().getOperationCallParamsAction_1_0() ||
  			   context == grammarAccess.getOrExpressionRule() ||
  			   context == grammarAccess.getOrExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getParanthesizedExpressionRule() ||
  			   context == grammarAccess.getPrimaryExpressionRule() ||
  			   context == grammarAccess.getRelationalExpressionRule() ||
  			   context == grammarAccess.getRelationalExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getSyntaxElementRule() ||
  			   context == grammarAccess.getUnaryOrInfixExpressionRule()) {
  				sequence_CollectionExpression_InfixExpression(context, (CollectionExpression) semanticObject); 
  				return; 
  			}
  			else break;
  		case ExpressionPackage.CONSTRUCTOR_CALL_EXPRESSION:
  			sequence_ConstructorCallExpression(context, (ConstructorCallExpression) semanticObject); 
  			return; 
  		case ExpressionPackage.FEATURE_CALL:
  			if(context == grammarAccess.getFeatureCallRule()) {
  				sequence_FeatureCall(context, (FeatureCall) semanticObject); 
  				return; 
  			}
  			else if(context == grammarAccess.getAdditiveExpressionRule() ||
  			   context == grammarAccess.getAdditiveExpressionAccess().getOperationCallParamsAction_1_0() ||
  			   context == grammarAccess.getAndExpressionRule() ||
  			   context == grammarAccess.getAndExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getChainExpressionRule() ||
  			   context == grammarAccess.getChainExpressionAccess().getChainExpressionFirstAction_1_0() ||
  			   context == grammarAccess.getChainedExpressionRule() ||
  			   context == grammarAccess.getExpressionRule() ||
  			   context == grammarAccess.getIfExpressionTriRule() ||
  			   context == grammarAccess.getIfExpressionTriAccess().getIfExpressionConditionAction_1_0() ||
  			   context == grammarAccess.getImpliesExpressionRule() ||
  			   context == grammarAccess.getImpliesExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getInfixExpressionRule() ||
  			   context == grammarAccess.getInfixExpressionAccess().getCollectionExpressionTargetAction_1_3_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getFeatureCallTargetAction_1_1_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getOperationCallTargetAction_1_0_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getTypeSelectExpressionTargetAction_1_2_0() ||
  			   context == grammarAccess.getMultiplicativeExpressionRule() ||
  			   context == grammarAccess.getMultiplicativeExpressionAccess().getOperationCallParamsAction_1_0() ||
  			   context == grammarAccess.getOrExpressionRule() ||
  			   context == grammarAccess.getOrExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getParanthesizedExpressionRule() ||
  			   context == grammarAccess.getPrimaryExpressionRule() ||
  			   context == grammarAccess.getRelationalExpressionRule() ||
  			   context == grammarAccess.getRelationalExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getSyntaxElementRule() ||
  			   context == grammarAccess.getUnaryOrInfixExpressionRule()) {
  				sequence_FeatureCall_InfixExpression(context, (FeatureCall) semanticObject); 
  				return; 
  			}
  			else break;
  		case ExpressionPackage.GLOBAL_VAR_EXPRESSION:
  			sequence_GlobalVarExpression(context, (GlobalVarExpression) semanticObject); 
  			return; 
  		case ExpressionPackage.IDENTIFIER:
  			if(context == grammarAccess.getCollectionTypeRule()) {
  				sequence_CollectionType(context, (Identifier) semanticObject); 
  				return; 
  			}
  			else if(context == grammarAccess.getSyntaxElementRule() ||
  			   context == grammarAccess.getTypeRule()) {
  				sequence_CollectionType_SimpleType_Type(context, (Identifier) semanticObject); 
  				return; 
  			}
  			else if(context == grammarAccess.getSimpleTypeRule()) {
  				sequence_SimpleType(context, (Identifier) semanticObject); 
  				return; 
  			}
  			else break;
  		case ExpressionPackage.IF_EXPRESSION:
  			if(context == grammarAccess.getAdditiveExpressionRule() ||
  			   context == grammarAccess.getAdditiveExpressionAccess().getOperationCallParamsAction_1_0() ||
  			   context == grammarAccess.getAndExpressionRule() ||
  			   context == grammarAccess.getAndExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getChainExpressionRule() ||
  			   context == grammarAccess.getChainExpressionAccess().getChainExpressionFirstAction_1_0() ||
  			   context == grammarAccess.getChainedExpressionRule() ||
  			   context == grammarAccess.getExpressionRule() ||
  			   context == grammarAccess.getIfExpressionTriRule() ||
  			   context == grammarAccess.getIfExpressionTriAccess().getIfExpressionConditionAction_1_0() ||
  			   context == grammarAccess.getImpliesExpressionRule() ||
  			   context == grammarAccess.getImpliesExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getInfixExpressionRule() ||
  			   context == grammarAccess.getInfixExpressionAccess().getCollectionExpressionTargetAction_1_3_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getFeatureCallTargetAction_1_1_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getOperationCallTargetAction_1_0_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getTypeSelectExpressionTargetAction_1_2_0() ||
  			   context == grammarAccess.getMultiplicativeExpressionRule() ||
  			   context == grammarAccess.getMultiplicativeExpressionAccess().getOperationCallParamsAction_1_0() ||
  			   context == grammarAccess.getOrExpressionRule() ||
  			   context == grammarAccess.getOrExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getParanthesizedExpressionRule() ||
  			   context == grammarAccess.getPrimaryExpressionRule() ||
  			   context == grammarAccess.getRelationalExpressionRule() ||
  			   context == grammarAccess.getRelationalExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getSyntaxElementRule() ||
  			   context == grammarAccess.getUnaryOrInfixExpressionRule()) {
  				sequence_ChainedExpression_IfExpressionKw_IfExpressionTri(context, (IfExpression) semanticObject); 
  				return; 
  			}
  			else if(context == grammarAccess.getIfExpressionKwRule()) {
  				sequence_IfExpressionKw(context, (IfExpression) semanticObject); 
  				return; 
  			}
  			else break;
  		case ExpressionPackage.INTEGER_LITERAL:
  			sequence_IntegerLiteral(context, (IntegerLiteral) semanticObject); 
  			return; 
  		case ExpressionPackage.LET_EXPRESSION:
  			sequence_LetExpression(context, (LetExpression) semanticObject); 
  			return; 
  		case ExpressionPackage.LIST_LITERAL:
  			sequence_ListLiteral(context, (ListLiteral) semanticObject); 
  			return; 
  		case ExpressionPackage.NULL_LITERAL:
  			sequence_NullLiteral(context, (NullLiteral) semanticObject); 
  			return; 
  		case ExpressionPackage.OPERATION_CALL:
  			if(context == grammarAccess.getAdditiveExpressionRule() ||
  			   context == grammarAccess.getAdditiveExpressionAccess().getOperationCallParamsAction_1_0() ||
  			   context == grammarAccess.getAndExpressionRule() ||
  			   context == grammarAccess.getAndExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getChainExpressionRule() ||
  			   context == grammarAccess.getChainExpressionAccess().getChainExpressionFirstAction_1_0() ||
  			   context == grammarAccess.getChainedExpressionRule() ||
  			   context == grammarAccess.getExpressionRule() ||
  			   context == grammarAccess.getIfExpressionTriRule() ||
  			   context == grammarAccess.getIfExpressionTriAccess().getIfExpressionConditionAction_1_0() ||
  			   context == grammarAccess.getImpliesExpressionRule() ||
  			   context == grammarAccess.getImpliesExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getInfixExpressionRule() ||
  			   context == grammarAccess.getInfixExpressionAccess().getCollectionExpressionTargetAction_1_3_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getFeatureCallTargetAction_1_1_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getOperationCallTargetAction_1_0_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getTypeSelectExpressionTargetAction_1_2_0() ||
  			   context == grammarAccess.getMultiplicativeExpressionRule() ||
  			   context == grammarAccess.getMultiplicativeExpressionAccess().getOperationCallParamsAction_1_0() ||
  			   context == grammarAccess.getOrExpressionRule() ||
  			   context == grammarAccess.getOrExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getParanthesizedExpressionRule() ||
  			   context == grammarAccess.getPrimaryExpressionRule() ||
  			   context == grammarAccess.getRelationalExpressionRule() ||
  			   context == grammarAccess.getRelationalExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getSyntaxElementRule() ||
  			   context == grammarAccess.getUnaryOrInfixExpressionRule()) {
  				sequence_AdditiveExpression_InfixExpression_MultiplicativeExpression_OperationCall_UnaryExpression_UnaryOrInfixExpression(context, (OperationCall) semanticObject); 
  				return; 
  			}
  			else if(context == grammarAccess.getFeatureCallRule() ||
  			   context == grammarAccess.getOperationCallRule()) {
  				sequence_OperationCall(context, (OperationCall) semanticObject); 
  				return; 
  			}
  			else if(context == grammarAccess.getUnaryExpressionRule()) {
  				sequence_UnaryExpression(context, (OperationCall) semanticObject); 
  				return; 
  			}
  			else break;
  		case ExpressionPackage.REAL_LITERAL:
  			sequence_RealLiteral(context, (RealLiteral) semanticObject); 
  			return; 
  		case ExpressionPackage.STRING_LITERAL:
  			sequence_StringLiteral(context, (StringLiteral) semanticObject); 
  			return; 
  		case ExpressionPackage.SWITCH_EXPRESSION:
  			sequence_SwitchExpression(context, (SwitchExpression) semanticObject); 
  			return; 
  		case ExpressionPackage.TYPE_SELECT_EXPRESSION:
  			if(context == grammarAccess.getAdditiveExpressionRule() ||
  			   context == grammarAccess.getAdditiveExpressionAccess().getOperationCallParamsAction_1_0() ||
  			   context == grammarAccess.getAndExpressionRule() ||
  			   context == grammarAccess.getAndExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getChainExpressionRule() ||
  			   context == grammarAccess.getChainExpressionAccess().getChainExpressionFirstAction_1_0() ||
  			   context == grammarAccess.getChainedExpressionRule() ||
  			   context == grammarAccess.getExpressionRule() ||
  			   context == grammarAccess.getIfExpressionTriRule() ||
  			   context == grammarAccess.getIfExpressionTriAccess().getIfExpressionConditionAction_1_0() ||
  			   context == grammarAccess.getImpliesExpressionRule() ||
  			   context == grammarAccess.getImpliesExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getInfixExpressionRule() ||
  			   context == grammarAccess.getInfixExpressionAccess().getCollectionExpressionTargetAction_1_3_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getFeatureCallTargetAction_1_1_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getOperationCallTargetAction_1_0_0() ||
  			   context == grammarAccess.getInfixExpressionAccess().getTypeSelectExpressionTargetAction_1_2_0() ||
  			   context == grammarAccess.getMultiplicativeExpressionRule() ||
  			   context == grammarAccess.getMultiplicativeExpressionAccess().getOperationCallParamsAction_1_0() ||
  			   context == grammarAccess.getOrExpressionRule() ||
  			   context == grammarAccess.getOrExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getParanthesizedExpressionRule() ||
  			   context == grammarAccess.getPrimaryExpressionRule() ||
  			   context == grammarAccess.getRelationalExpressionRule() ||
  			   context == grammarAccess.getRelationalExpressionAccess().getBooleanOperationLeftAction_1_0() ||
  			   context == grammarAccess.getSyntaxElementRule() ||
  			   context == grammarAccess.getUnaryOrInfixExpressionRule()) {
  				sequence_InfixExpression_TypeSelectExpression(context, (TypeSelectExpression) semanticObject); 
  				return; 
  			}
  			else if(context == grammarAccess.getFeatureCallRule() ||
  			   context == grammarAccess.getTypeSelectExpressionRule()) {
  				sequence_TypeSelectExpression(context, (TypeSelectExpression) semanticObject); 
  				return; 
  			}
  			else break;
  		}
  	if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
  }

  /**
   * Constraint:
   *     attribute=[EAttribute|ID]
   */
  protected void sequence_Attribute(EObject context, Attribute semanticObject) {
  	if(errorAcceptor != null) {
  		if(transientValues.isValueTransient(semanticObject, ExportPackage.Literals.ATTRIBUTE__ATTRIBUTE) == ValueTransient.YES)
  			errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExportPackage.Literals.ATTRIBUTE__ATTRIBUTE));
  	}
  	INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
  	SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
  	feeder.accept(grammarAccess.getAttributeAccess().getAttributeEAttributeIDTerminalRuleCall_0_1(), semanticObject.getAttribute());
  	feeder.finish();
  }
  
  
  /**
   * Constraint:
   *     (imports+=Import+ extensions+=Extension* interfaces+=Interface* exports+=Export+)
   */
  protected void sequence_ExportModel(EObject context, ExportModel semanticObject) {
  	genericSequencer.createSequence(context, semanticObject);
  }
  
  
  /**
   * Constraint:
   *     (
   *         allowLookup?='lookup'? 
   *         type=[EClass|QualifiedID] 
   *         (qualifiedName?='qualified'? naming=Expression)? 
   *         guard=Expression? 
   *         (fragmentUnique?='unique'? fragmentAttribute=[EAttribute|ID])? 
   *         (fingerprint?='object-fingerprint' | resourceFingerprint?='resource-fingerprint')? 
   *         ((attributes+=Attribute attributes+=Attribute*) | (userData+=UserData userData+=UserData*))*
   *     )
   */
  protected void sequence_Export(EObject context, Export semanticObject) {
  	genericSequencer.createSequence(context, semanticObject);
  }
  
  
  /**
   * Constraint:
   *     extension=QualifiedID
   */
  protected void sequence_Extension(EObject context, Extension semanticObject) {
  	if(errorAcceptor != null) {
  		if(transientValues.isValueTransient(semanticObject, ExportPackage.Literals.EXTENSION__EXTENSION) == ValueTransient.YES)
  			errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExportPackage.Literals.EXTENSION__EXTENSION));
  	}
  	INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
  	SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
  	feeder.accept(grammarAccess.getExtensionAccess().getExtensionQualifiedIDParserRuleCall_1_0(), semanticObject.getExtension());
  	feeder.finish();
  }
  
  
  /**
   * Constraint:
   *     (package=[EPackage|STRING] name=ID?)
   */
  protected void sequence_Import(EObject context, Import semanticObject) {
  	genericSequencer.createSequence(context, semanticObject);
  }
  
  
  /**
   * Constraint:
   *     (ref?='@'? unordered?='+'? expr=Expression)
   */
  protected void sequence_InterfaceExpression(EObject context, InterfaceExpression semanticObject) {
  	genericSequencer.createSequence(context, semanticObject);
  }
  
  
  /**
   * Constraint:
   *     (unordered?='+'? field=[EStructuralFeature|ID])
   */
  protected void sequence_InterfaceField(EObject context, InterfaceField semanticObject) {
  	genericSequencer.createSequence(context, semanticObject);
  }
  
  
  /**
   * Constraint:
   *     (unordered?='+'? ref=[EReference|ID])
   */
  protected void sequence_InterfaceNavigation(EObject context, InterfaceNavigation semanticObject) {
  	genericSequencer.createSequence(context, semanticObject);
  }
  
  
  /**
   * Constraint:
   *     (type=[EClass|QualifiedID] guard=Expression? (items+=InterfaceItem items+=InterfaceItem*)*)
   */
  protected void sequence_Interface(EObject context, Interface semanticObject) {
  	genericSequencer.createSequence(context, semanticObject);
  }
  
  
  /**
   * Constraint:
   *     (name=ID expr=Expression)
   */
  protected void sequence_UserData(EObject context, UserData semanticObject) {
  	if(errorAcceptor != null) {
  		if(transientValues.isValueTransient(semanticObject, ExportPackage.Literals.USER_DATA__NAME) == ValueTransient.YES)
  			errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExportPackage.Literals.USER_DATA__NAME));
  		if(transientValues.isValueTransient(semanticObject, ExportPackage.Literals.USER_DATA__EXPR) == ValueTransient.YES)
  			errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExportPackage.Literals.USER_DATA__EXPR));
  	}
  	INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
  	SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
  	feeder.accept(grammarAccess.getUserDataAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
  	feeder.accept(grammarAccess.getUserDataAccess().getExprExpressionParserRuleCall_2_0(), semanticObject.getExpr());
  	feeder.finish();
  }
}
