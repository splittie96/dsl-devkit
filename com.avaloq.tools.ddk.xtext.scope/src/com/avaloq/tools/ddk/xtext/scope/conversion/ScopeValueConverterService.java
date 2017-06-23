/*******************************************************************************
 * Copyright (c) 2016 Avaloq Evolution AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Avaloq Evolution AG - initial API and implementation
 *******************************************************************************/
package com.avaloq.tools.ddk.xtext.scope.conversion;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;

import com.avaloq.tools.ddk.xtext.expression.conversion.ExpressionValueConverterService;
import com.google.inject.Inject;


/**
 * Value converter service for the scope DSL.
 */
public class ScopeValueConverterService extends ExpressionValueConverterService {

  @Inject
  private QualifiedNameValueConverter dottedIDConverter;

  @Inject
  private ExtensionIdValueConverter qualifiedIDConverter;

  /**
   * Value converter for qualified extension IDs which are delimited using "::".
   */
  private static final class ExtensionIdValueConverter extends QualifiedNameValueConverter {
    @Override
    protected String getNamespaceDelimiter() {
      return "::";
    }
  }

  /**
   * Value converter for QualifiedID rule.
   * 
   * @return value converter
   */
  @ValueConverter(rule = "QualifiedID")
  public IValueConverter<String> convertQualifiedID() {
    return qualifiedIDConverter;
  }

  /**
   * Value converter for DottedID rule.
   * 
   * @return value converter
   */
  @ValueConverter(rule = "DottedID")
  public IValueConverter<String> convertDottedID() {
    return dottedIDConverter;
  }

}
