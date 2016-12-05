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
package com.avaloq.tools.ddk.checkcfg.ui.templates;

import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateAcceptor;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;
import org.eclipse.xtext.ui.editor.templates.DefaultTemplateProposalProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;

import com.avaloq.tools.ddk.check.check.Check;
import com.avaloq.tools.ddk.check.check.CheckCatalog;
import com.avaloq.tools.ddk.check.check.FormalParameter;
import com.avaloq.tools.ddk.checkcfg.checkcfg.CheckConfiguration;
import com.avaloq.tools.ddk.checkcfg.checkcfg.CheckcfgPackage;
import com.avaloq.tools.ddk.checkcfg.checkcfg.ConfiguredCatalog;
import com.avaloq.tools.ddk.checkcfg.checkcfg.ConfiguredCheck;
import com.avaloq.tools.ddk.checkcfg.ui.labeling.CheckCfgImages;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;


/**
 * The template proposal provider for Check Configuration templates.
 */
public class CheckCfgTemplateProposalProvider extends DefaultTemplateProposalProvider {

  @Inject
  private CheckCfgImages images;

  @Inject
  private IScopeProvider scopeProvider;

  @Inject
  private XbaseInterpreter interpreter;

  private final TemplateStore templateStore;

  @Inject
  public CheckCfgTemplateProposalProvider(final TemplateStore templateStore, final ContextTypeRegistry registry, final ContextTypeIdHelper helper) {
    super(templateStore, registry, helper);
    this.templateStore = templateStore;
  }

  @Override
  public Image getImage(final Template template) {
    if (Strings.equal("CheckConfiguration", template.getName())) { // see templates.xml
      return images.forCheckConfiguration();
    } else if (Strings.equal("Add a catalog", template.getName())) { // see templates.xml
      return images.forConfiguredCatalog();
    }
    return super.getImage(template);
  }

  @Override
  protected void createTemplates(final TemplateContext templateContext, final ContentAssistContext context, final ITemplateAcceptor acceptor) {
    if (templateContext.getContextType().getId().equals("com.avaloq.tools.ddk.checkcfg.CheckCfg.ConfiguredCheck")) {
      addConfiguredCheckTemplates(templateContext, context, acceptor);
      return;
    } else if (templateContext.getContextType().getId().equals("com.avaloq.tools.ddk.checkcfg.CheckCfg.kw_catalog")) {
      addCatalogConfigurations(templateContext, context, acceptor);
    }
    TemplateContextType contextType = templateContext.getContextType();
    Template[] templates = templateStore.getTemplates(contextType.getId());
    for (Template template : templates) {

      if (!acceptor.canAcceptMoreTemplates()) {
        return;
      }
      if (validate(template, templateContext)) {
        acceptor.accept(createProposal(template, templateContext, context, getImage(template), getRelevance(template)));
      }
    }
  }

  /**
   * Adds the populated check configuration.
   * 
   * @param templateContext
   *          the template context
   * @param context
   *          the context
   * @param acceptor
   *          the acceptor
   */
  @SuppressWarnings("all")
  private void addCatalogConfigurations(final TemplateContext templateContext, final ContentAssistContext context, final ITemplateAcceptor acceptor) {
    final String templateName = "Add all registered catalogs";
    final String templateDescription = "configures all missing catalogs";

    final String contextTypeId = templateContext.getContextType().getId();
    if (context.getRootModel() instanceof CheckConfiguration) {
      final CheckConfiguration conf = (CheckConfiguration) context.getRootModel();
      List<IEObjectDescription> allElements = Lists.newArrayList(scopeProvider.getScope(conf, CheckcfgPackage.Literals.CONFIGURED_CATALOG__CATALOG).getAllElements());

      StringBuilder builder = new StringBuilder();
      for (IEObjectDescription description : allElements) {
        if (description instanceof EObjectDescription && description.getEObjectOrProxy() instanceof CheckCatalog) {
          CheckCatalog catalog = (CheckCatalog) description.getEObjectOrProxy();
          if (catalog.eIsProxy()) {
            catalog = (CheckCatalog) EcoreUtil.resolve(catalog, conf);
          }
          if (isCatalogConfigured(conf, catalog)) {
            continue;
          } else if (allElements.indexOf(description) > 0) {
            builder.append(Strings.newLine());
          }

          builder.append("catalog ").append(description.getQualifiedName()).append(" {").append(Strings.newLine());
          for (Check check : catalog.getAllChecks()) {
            builder.append("  default ").append(check.getName()).append(Strings.newLine());
          }
          // CHECKSTYLE:OFF
          builder.append("}");
          builder.append(Strings.newLine());
          // CHECKSTYLE:ON
        }

      }

      if (builder.length() > 0) {
        builder.append("${cursor}");
        Template t = new Template(templateName, templateDescription, contextTypeId, builder.toString(), true);
        TemplateProposal tp = createProposal(t, templateContext, context, images.forConfiguredCatalog(), getRelevance(t));
        acceptor.accept(tp);
      }
    }
  }

  /**
   * Checks if is catalog configured.
   * 
   * @param conf
   *          the check configuration
   * @param catalog
   *          the catalog
   * @return true, if is catalog configured
   */
  private boolean isCatalogConfigured(final CheckConfiguration conf, final CheckCatalog catalog) {
    try {
      Iterables.find(conf.getLegacyCatalogConfigurations(), new Predicate<ConfiguredCatalog>() {
        @Override
        public boolean apply(final ConfiguredCatalog input) {
          if (input.getCatalog() == null || input.getCatalog().getName() == null || input.getCatalog().getPackageName() == null) {
            return false;
          }
          return catalog == input.getCatalog()
              || (input.getCatalog().getName().equals(catalog.getName()) && input.getCatalog().getPackageName().equals(catalog.getPackageName()));
        }
      });
    } catch (NoSuchElementException e) {
      return false;
    }
    return true;
  }

  /**
   * Adds template proposals for all checks which may be referenced in current catalog configuration. Only proposals for checks
   * which have not yet been configured are provided.
   * 
   * @param templateContext
   *          the template context
   * @param context
   *          the context
   * @param acceptor
   *          the acceptor
   */
  private void addConfiguredCheckTemplates(final TemplateContext templateContext, final ContentAssistContext context, final ITemplateAcceptor acceptor) { // NOPMD
    ConfiguredCatalog configuredCatalog = EcoreUtil2.getContainerOfType(context.getCurrentModel(), ConfiguredCatalog.class);
    Iterable<String> alreadyConfiguredCheckNames = Iterables.filter(Iterables.transform(configuredCatalog.getCheckConfigurations(), new Function<ConfiguredCheck, String>() {
      @Override
      public String apply(final ConfiguredCheck from) {
        if (from.getCheck() != null) {
          return from.getCheck().getName();
        }
        return null;
      }
    }), Predicates.notNull());
    final CheckCatalog catalog = configuredCatalog.getCatalog();
    for (final Check check : catalog.getAllChecks()) {
      // create a template on the fly
      final String checkName = check.getName();
      if (!check.isFinal() && !Iterables.contains(alreadyConfiguredCheckNames, checkName)) {

        // check if referenced check has configurable parameters
        String paramString = "";
        if (!catalog.isFinal() && !check.isFinal() && !check.getFormalParameters().isEmpty()) {
          StringBuilder params = new StringBuilder("(");
          for (final FormalParameter p : check.getFormalParameters()) {
            final String paramName = p.getName();
            final String defaultValue = String.valueOf(interpreter.evaluate(p.getRight()).getResult());
            params.append(paramName).append(" = ").append("${").append(defaultValue).append("}");
            params.append(", ");
          }
          if (params.length() > 2) {
            paramString = params.substring(0, params.length() - 2) + ")";
          }
        }

        final String severity = (catalog.isFinal() || check.isFinal()) ? "default " : "${default:Enum('SeverityKind')} ";
        final String description = "Configures the check \"" + check.getLabel() + "\"";
        final String contextTypeId = "com.avaloq.tools.ddk.checkcfg.CheckCfg.ConfiguredCheck." + checkName;
        final String pattern = severity + checkName + (paramString.length() == 0 ? "${cursor}" : " " + paramString + "${cursor}");

        Template t = new Template(checkName, description, contextTypeId, pattern, true);
        TemplateProposal tp = createProposal(t, templateContext, context, images.forConfiguredCheck(check.getDefaultSeverity()), getRelevance(t));
        acceptor.accept(tp);
      }
    }
  }

}
