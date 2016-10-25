/*
 * Copyright (c) 2015年4月15日 by XuanWu Wireless Technology Co., Ltd. 
 *             All rights reserved                         
 */
package com.licc.common.util;

/**
 * 分页类
 * Created by Jake on 2/21 0021.
 */
public class PageInfo {

	/** 记录开始位置 */
	private int from;

	/** 当前页码，从1开始 */
	private int page;

	/** 页大小 */
	private int size;

	/** 总记录数 */
	private int total;

	public PageInfo() {
	}

	/**
	 * @param page
	 *            页码：从1开始
	 * @param size
	 *            页大小：大于0
	 */
	public PageInfo(int page, int size) {
		if (page < 1)
			throw new IllegalArgumentException("page: " + page);
		if (size < 1)
			throw new IllegalArgumentException("size: " + size);
		this.page = page;
		this.size = size;

		resetTotal(total);
	}

	public int getFrom() {
		return from;
	}

	public int getPage() {
		return page;
	}

	public int getSize() {
		return size;
	}

	public int getTotal() {
		return total;
	}

	public PageInfo resetTotal(int total) {
		int pages = total / size;
		if (total % size > 0) {
			pages++;
		}
		if (page > pages) {
			page = pages;
		}
		if (pages == 0 || page <= 0) {
			page = 1;
		}
		from = (page - 1) * size;
		if (from > total) {
			from = total;
		}
		return this;
	}

}
