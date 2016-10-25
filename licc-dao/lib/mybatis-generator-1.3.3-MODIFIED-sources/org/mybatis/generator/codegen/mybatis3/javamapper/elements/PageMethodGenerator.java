package org.mybatis.generator.codegen.mybatis3.javamapper.elements;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Jake on 2/20 0020.
 */
public class PageMethodGenerator extends AbstractJavaMapperMethodGenerator {

    @Override
    public void addInterfaceElements(Interface interfaze) {

        if (introspectedTable.getPrimaryKeyColumns().size() != 1) {
            return;
        }

        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());


        // 添加page方法
        Method pageMethod = new Method();
        pageMethod.setVisibility(JavaVisibility.PUBLIC);

        FullyQualifiedJavaType returnType = FullyQualifiedJavaType
                .getNewListInstance();
        FullyQualifiedJavaType listType = new FullyQualifiedJavaType(
                introspectedTable.getBaseRecordType());

        importedTypes.add(listType);
        returnType.addTypeArgument(listType);
        pageMethod.setReturnType(returnType);
        importedTypes.add(returnType);

        if (introspectedTable.getPageStatementId() != null) {
            pageMethod.setName(introspectedTable.getPageStatementId());
        } else {
            String pageMethodName = context.getProperty("pageMethodName");
            if (pageMethodName == null) {
                pageMethodName = "page";
            }
            pageMethod.setName(pageMethodName);
        }



        String queryParameterType = context.getProperty("queryParameterType");
        if (queryParameterType == null) {
            queryParameterType = "java.util.Map";
        }
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(queryParameterType);
        importedTypes.add(type);

        String queryParamName = context.getProperty("queryParamName");
        if (queryParamName == null) {
            queryParamName = "param";
        }
        pageMethod.addParameter(new Parameter(type, queryParamName)); //$NON-NLS-1$

        context.getCommentGenerator().addGeneralMethodComment(pageMethod,
                introspectedTable);


        // 添加count方法
        Method countMethod = new Method();
        countMethod.setVisibility(JavaVisibility.PUBLIC);

        String countMethodName = context.getProperty("countMethodName");
        if (countMethodName == null) {
            countMethodName = "count";
        }
        countMethod.setName(countMethodName);

        countMethod.setReturnType(FullyQualifiedJavaType.getIntInstance());
        countMethod.addParameter(new Parameter(type, queryParamName)); //$NON-NLS-1$

        context.getCommentGenerator().addGeneralMethodComment(countMethod,
                introspectedTable);

        if (context.getPlugins()
                .clientPageMethodGenerated(pageMethod,
                        interfaze, introspectedTable)) {
            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(pageMethod);
            interfaze.addMethod(countMethod);
        }
    }
}
