package com.licc.dao.base;

import java.io.Serializable;

/**
 * <b>领域实体接口。</b>
 * <li>所有实体类都要直接或间接实现这个接口。</li>
 * <li>它主要起标记作用，以便于统一处理系统中的实体等。</li>
 * @author  lichangchao
 */
public interface IEntity extends Serializable {

	/**
	 * 取得实体的Id。实体类的每个实例都必须有个唯一Id以标识自身。
	 * 实体Id必须是可序列化的。
	 * @return 实体实例的 Id.
	 */
	Serializable getId();
	
}
