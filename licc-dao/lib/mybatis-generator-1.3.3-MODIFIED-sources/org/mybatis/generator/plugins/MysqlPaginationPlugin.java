package org.mybatis.generator.plugins;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * @author pan.wei
 * @date 2011-11-30 下午08:36:11
 */
public class MysqlPaginationPlugin extends PluginAdapter {

	@Override
	public boolean sqlMapPageElementGenerated(
			XmlElement parentElement, IntrospectedTable introspectedTable) {

		if (introspectedTable.getPrimaryKeyColumns().size() != 1) {
			return true;
		}

		String fqjt = context.getProperty("queryParameterType");
		if (fqjt == null) {
			fqjt = "java.util.Map";
		}

		String pageMapperId;
		if (introspectedTable.getPageStatementId() != null) {
			pageMapperId = introspectedTable.getPageStatementId();
		} else {
			pageMapperId = context.getProperty("pageMethodName");
			if (pageMapperId == null) {
				pageMapperId = "page";
			}
		}

		addPageElement(parentElement, introspectedTable, fqjt, pageMapperId);


		String countMapperId = context.getProperty("countMethodName");
		addCountElement(parentElement, introspectedTable, fqjt, countMapperId);

		return true;
	}


	private void addPageElement(XmlElement parentElement, IntrospectedTable introspectedTable, String fqjt, String mapperId) {
		// 添加page查询元素
		XmlElement answer = new XmlElement("select"); //$NON-NLS-1$

		answer.addAttribute(new Attribute("id", mapperId));
		answer.addAttribute(new Attribute(
				"resultMap", introspectedTable.getBaseResultMapId())); //$NON-NLS-1$
		answer.addAttribute(new Attribute("parameterType", fqjt)); //$NON-NLS-1$

		context.getCommentGenerator().addComment(answer);

		answer.addElement(new TextElement("select")); //$NON-NLS-1$
		answer.addElement(getBaseColumnListElement(introspectedTable));

		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		sb.append("from "); //$NON-NLS-1$
		sb.append(introspectedTable
				.getAliasedFullyQualifiedTableNameAtRuntime());
		answer.addElement((new TextElement(sb.toString())));
		answer.addElement(getExampleIncludeElement(introspectedTable));

		XmlElement ifElement = new XmlElement("if"); //$NON-NLS-1$
		ifElement.addAttribute(new Attribute("test", "sorts != null")); //$NON-NLS-1$ //$NON-NLS-2$

		XmlElement forEachElement = new XmlElement("foreach");
		forEachElement.addAttribute(new Attribute("item", "value"));
		forEachElement.addAttribute(new Attribute("index", "key"));
		forEachElement.addAttribute(new Attribute("collection", "sorts"));
		forEachElement.addAttribute(new Attribute("open", "order by"));
		forEachElement.addAttribute(new Attribute("separator", ","));

		forEachElement.addElement(new TextElement("${key} ${value}"));

		ifElement.addElement(forEachElement);
		answer.addElement(ifElement);

		XmlElement page = new XmlElement("if");
		page.addAttribute(new Attribute("test", "page != null"));
		page.addElement(new TextElement("limit #{page.from} , #{page.size}"));
		answer.addElement(page);

		parentElement.addElement(answer);

		addExampleConditionElement(parentElement, introspectedTable);
	}


	private void addCountElement(XmlElement parentElement, IntrospectedTable introspectedTable, String fqjt, String mapperId) {
		// 添加page查询元素
		XmlElement answer = new XmlElement("select"); //$NON-NLS-1$

		answer.addAttribute(new Attribute("id", mapperId));
		answer.addAttribute(new Attribute(
				"resultType", "int")); //$NON-NLS-1$
		answer.addAttribute(new Attribute("parameterType", fqjt)); //$NON-NLS-1$

		context.getCommentGenerator().addComment(answer);

		answer.addElement(new TextElement("select")); //$NON-NLS-1$
		answer.addElement(new TextElement("count(1)"));

		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		sb.append("from "); //$NON-NLS-1$
		sb.append(introspectedTable
				.getAliasedFullyQualifiedTableNameAtRuntime());
		answer.addElement((new TextElement(sb.toString())));
		answer.addElement(getExampleIncludeElement(introspectedTable));

		parentElement.addElement(answer);

	}


	protected XmlElement getBaseColumnListElement(IntrospectedTable introspectedTable) {
		XmlElement answer = new XmlElement("include"); //$NON-NLS-1$
		answer.addAttribute(new Attribute("refid", //$NON-NLS-1$
				introspectedTable.getBaseColumnListId()));
		return answer;
	}

	protected XmlElement getExampleIncludeElement(IntrospectedTable introspectedTable) {
		XmlElement ifElement = new XmlElement("if"); //$NON-NLS-1$
		ifElement.addAttribute(new Attribute("test", "params != null")); //$NON-NLS-1$ //$NON-NLS-2$

		XmlElement includeElement = new XmlElement("include"); //$NON-NLS-1$
		includeElement.addAttribute(new Attribute("refid", "exampleCondition"));
		ifElement.addElement(includeElement);

		return ifElement;
	}

	protected void addExampleConditionElement(XmlElement parentElement, IntrospectedTable introspectedTable) {
		XmlElement answer = new XmlElement("sql"); //$NON-NLS-1$
		answer.addAttribute(new Attribute("id", "exampleCondition")); //$NON-NLS-1$

		XmlElement whereElement = new XmlElement("where"); //$NON-NLS-1$
		answer.addElement(whereElement);

		List<IntrospectedColumn> allBaseColumns = introspectedTable.getBaseColumns();
		for (IntrospectedColumn column : allBaseColumns) {
			XmlElement ifElement = new XmlElement("if"); //$NON-NLS-1$
			ifElement.addAttribute(new Attribute("test", "params." + column.getJavaProperty() + " != null"));
			if ("java.lang.String".equals(column.getFullyQualifiedJavaType().getFullyQualifiedName())) {
				ifElement.addElement(new TextElement("and " + column.getActualColumnName() + " like '%${params." + column.getJavaProperty() + "}%'"));
			} else {
				ifElement.addElement(new TextElement("and " + column.getActualColumnName() + " = #{params." + column.getJavaProperty() + "}"));
			}

			whereElement.addElement(ifElement);
		}

		parentElement.addElement(answer);
	}

	/**
	 * This plugin is always valid - no properties are required
	 */
	public boolean validate(List<String> warnings) {
		return true;
	}
}
