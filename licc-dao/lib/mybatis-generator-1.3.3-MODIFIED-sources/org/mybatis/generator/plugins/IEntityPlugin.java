/*
 *  Copyright 2008 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.beans.Introspector;
import java.util.List;
import java.util.Properties;

/**
 * 基础
 */
public class IEntityPlugin extends PluginAdapter {

    private FullyQualifiedJavaType iEntityInterface;
    private FullyQualifiedJavaType serializable;
    private boolean suppressJavaInterface;

    public IEntityPlugin() {
        super();
        serializable = new FullyQualifiedJavaType("java.io.Serializable"); //$NON-NLS-1$
    }

    public boolean validate(List<String> warnings) {
        // this plugin is always valid
        return true;
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        suppressJavaInterface = Boolean.valueOf(properties.getProperty("suppressJavaInterface")); //$NON-NLS-1$
        iEntityInterface = new FullyQualifiedJavaType(properties.getProperty("interfaceClass")); //$NON-NLS-1$
    }
    
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        implementsIEntity(topLevelClass, introspectedTable);
        return true;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        implementsIEntity(topLevelClass, introspectedTable);
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(
            TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        implementsIEntity(topLevelClass, introspectedTable);
        return true;
    }

    protected void implementsIEntity(TopLevelClass topLevelClass,
                                     IntrospectedTable introspectedTable) {

        List<IntrospectedColumn> primaryKeys = introspectedTable.getPrimaryKeyColumns();
        if(primaryKeys.size() == 0) {
            return;
        }

        // 实现IEntity接口
        if (!suppressJavaInterface) {
            topLevelClass.addImportedType(iEntityInterface);
            topLevelClass.addSuperInterface(iEntityInterface);

            generateSerializableID(topLevelClass, introspectedTable);
        }

        // 实现getId()方法
        if (introspectedTable.getColumn("id") != null) {
            return;
        }

        if(primaryKeys.size() == 1) {
            IntrospectedColumn introspectedColumn = primaryKeys.get(0);
            FullyQualifiedJavaType fqjt = introspectedColumn
                    .getFullyQualifiedJavaType();
            String property = introspectedColumn.getJavaProperty();

            Method method = new Method();
            method.setVisibility(JavaVisibility.PUBLIC);
            method.setReturnType(fqjt);
            method.setName("getId");
            context.getCommentGenerator().addGetterComment(method,
                    introspectedTable, introspectedColumn);

            StringBuilder sb = new StringBuilder();
            sb.append("return "); //$NON-NLS-1$
            sb.append(property);
            sb.append(';');
            method.addBodyLine(sb.toString());
            topLevelClass.addMethod(method);
        } else {

            String keyType = introspectedTable.getPrimaryKeyType();
            keyType = keyType.substring(keyType.lastIndexOf('.')+1);

            FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(keyType);

            Method method = new Method();
            method.setVisibility(JavaVisibility.PUBLIC);
            method.setReturnType(fqjt);
            method.setName("getId");

            StringBuilder sb = new StringBuilder();
            // Key key = new Key();
            sb.append(keyType).append(" key = new ").append(keyType).append("();");

            for (IntrospectedColumn primaryKeyColumn : primaryKeys) {
                sb.append("\n\t\t");
                String property = primaryKeyColumn.getJavaProperty();
                // key.id1 = this.id1;
                sb.append("key.").append(getWriteMethodName(property)).append("(")
                        .append("this.").append(getReadMethodName(property)).append("());");
            }

            sb.append("\n\t\t");
            // return key;
            sb.append("return key;"); //$NON-NLS-1$
            method.addBodyLine(sb.toString());
            topLevelClass.addMethod(method);

        }

    }

    /**
     * 生成Serializable ID
     * @param topLevelClass
     * @param introspectedTable
     */
    private void generateSerializableID(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        Field field = new Field();
        field.setFinal(true);
        field.setInitializationString("1L"); //$NON-NLS-1$
        field.setName("serialVersionUID"); //$NON-NLS-1$
        field.setStatic(true);
        field.setType(new FullyQualifiedJavaType("long")); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PRIVATE);
        context.getCommentGenerator().addFieldComment(field, introspectedTable);

        topLevelClass.addField(field);
    }


    public static String getReadMethodName(String name) {
        return GET_PREFIX + capitalize(name);
    }

    public static String getWriteMethodName(String name) {
        return SET_PREFIX + capitalize(name);
    }

    /**
     * Returns a String which capitalizes the first letter of the string.
     */
    public static String capitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }


    static final String SET_PREFIX = "set";
    static final String GET_PREFIX = "get";
}
