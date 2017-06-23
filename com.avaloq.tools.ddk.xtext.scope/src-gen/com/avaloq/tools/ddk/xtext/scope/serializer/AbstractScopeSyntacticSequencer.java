/*
 * generated by Xtext
 */
package com.avaloq.tools.ddk.xtext.scope.serializer;

import com.avaloq.tools.ddk.xtext.scope.services.ScopeGrammarAccess;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractScopeSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ScopeGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ParanthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParanthesizedExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ScopeGrammarAccess) access;
		match_ParanthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParanthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_ParanthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParanthesizedExpressionAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_ParanthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParanthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParanthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParanthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '(' type=Type
	 *     (rule start) (ambiguity) 'GLOBALVAR' name=Identifier
	 *     (rule start) (ambiguity) 'if' condition=ChainedExpression
	 *     (rule start) (ambiguity) 'let' identifier=Identifier
	 *     (rule start) (ambiguity) 'new' type=SimpleType
	 *     (rule start) (ambiguity) 'switch' '(' switchExpr=OrExpression
	 *     (rule start) (ambiguity) 'switch' '{' 'default' ':' defaultExpr=OrExpression
	 *     (rule start) (ambiguity) 'switch' '{' case+=Case
	 *     (rule start) (ambiguity) '{' '}' (rule start)
	 *     (rule start) (ambiguity) '{' elements+=Expression
	 *     (rule start) (ambiguity) name='!'
	 *     (rule start) (ambiguity) name='-'
	 *     (rule start) (ambiguity) name='collect'
	 *     (rule start) (ambiguity) name='exists'
	 *     (rule start) (ambiguity) name='forAll'
	 *     (rule start) (ambiguity) name='notExists'
	 *     (rule start) (ambiguity) name='reject'
	 *     (rule start) (ambiguity) name='select'
	 *     (rule start) (ambiguity) name='selectFirst'
	 *     (rule start) (ambiguity) name='sortBy'
	 *     (rule start) (ambiguity) name='typeSelect'
	 *     (rule start) (ambiguity) name=Identifier
	 *     (rule start) (ambiguity) type=Type
	 *     (rule start) (ambiguity) val='false'
	 *     (rule start) (ambiguity) val='null'
	 *     (rule start) (ambiguity) val='true'
	 *     (rule start) (ambiguity) val=INT
	 *     (rule start) (ambiguity) val=REAL
	 *     (rule start) (ambiguity) val=STRING
	 *     (rule start) (ambiguity) {BooleanOperation.left=}
	 *     (rule start) (ambiguity) {ChainExpression.first=}
	 *     (rule start) (ambiguity) {CollectionExpression.target=}
	 *     (rule start) (ambiguity) {FeatureCall.target=}
	 *     (rule start) (ambiguity) {IfExpression.condition=}
	 *     (rule start) (ambiguity) {OperationCall.params+=}
	 *     (rule start) (ambiguity) {OperationCall.target=}
	 *     (rule start) (ambiguity) {TypeSelectExpression.target=}
	 */
	protected void emit_ParanthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '(' type=Type
	 *     (rule start) (ambiguity) 'GLOBALVAR' name=Identifier
	 *     (rule start) (ambiguity) 'if' condition=ChainedExpression
	 *     (rule start) (ambiguity) 'let' identifier=Identifier
	 *     (rule start) (ambiguity) 'new' type=SimpleType
	 *     (rule start) (ambiguity) 'switch' '(' switchExpr=OrExpression
	 *     (rule start) (ambiguity) 'switch' '{' 'default' ':' defaultExpr=OrExpression
	 *     (rule start) (ambiguity) 'switch' '{' case+=Case
	 *     (rule start) (ambiguity) '{' '}' ')' (rule start)
	 *     (rule start) (ambiguity) '{' elements+=Expression
	 *     (rule start) (ambiguity) name='!'
	 *     (rule start) (ambiguity) name='-'
	 *     (rule start) (ambiguity) name='collect'
	 *     (rule start) (ambiguity) name='exists'
	 *     (rule start) (ambiguity) name='forAll'
	 *     (rule start) (ambiguity) name='notExists'
	 *     (rule start) (ambiguity) name='reject'
	 *     (rule start) (ambiguity) name='select'
	 *     (rule start) (ambiguity) name='selectFirst'
	 *     (rule start) (ambiguity) name='sortBy'
	 *     (rule start) (ambiguity) name='typeSelect'
	 *     (rule start) (ambiguity) name=Identifier
	 *     (rule start) (ambiguity) type=Type
	 *     (rule start) (ambiguity) val='false'
	 *     (rule start) (ambiguity) val='null'
	 *     (rule start) (ambiguity) val='true'
	 *     (rule start) (ambiguity) val=INT
	 *     (rule start) (ambiguity) val=REAL
	 *     (rule start) (ambiguity) val=STRING
	 *     (rule start) (ambiguity) {BooleanOperation.left=}
	 *     (rule start) (ambiguity) {ChainExpression.first=}
	 *     (rule start) (ambiguity) {CollectionExpression.target=}
	 *     (rule start) (ambiguity) {FeatureCall.target=}
	 *     (rule start) (ambiguity) {IfExpression.condition=}
	 *     (rule start) (ambiguity) {OperationCall.params+=}
	 *     (rule start) (ambiguity) {OperationCall.target=}
	 *     (rule start) (ambiguity) {TypeSelectExpression.target=}
	 */
	protected void emit_ParanthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
