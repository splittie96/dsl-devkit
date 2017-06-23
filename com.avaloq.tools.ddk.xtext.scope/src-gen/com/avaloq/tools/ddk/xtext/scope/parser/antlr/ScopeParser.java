/*
 * generated by Xtext
 */
package com.avaloq.tools.ddk.xtext.scope.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import com.avaloq.tools.ddk.xtext.scope.services.ScopeGrammarAccess;

public class ScopeParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private ScopeGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected com.avaloq.tools.ddk.xtext.scope.parser.antlr.internal.InternalScopeParser createParser(XtextTokenStream stream) {
		return new com.avaloq.tools.ddk.xtext.scope.parser.antlr.internal.InternalScopeParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "ScopeModel";
	}
	
	public ScopeGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ScopeGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
