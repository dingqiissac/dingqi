package com.atguigu.entity;

import java.util.List;

public class Page<T> {
	@Override
	public String toString() {
		return "Page [totalRecodes=" + totalRecodes + ", totalPages=" + totalPages + ", beginPageOffset="
				+ beginPageOffset + ", limit=" + limit + ", data=" + data + ", pageNumber=" + pageNumber + "]";
	}

	//总记录
	private Integer totalRecodes;
	/**
	 * 总页码
	 */
	private Integer totalPages;
	/**
	 * 偏移量
	 */
	private Integer beginPageOffset;
	/**
	 * 每页记录数
	 */
	private Integer limit;
	/**
	 * 当前页面的数据集合
	 */
	private List<T> data;
	/**
	 * 当前页码
	 */
	private int pageNumber;

	public Integer getTotalRecodes() {
		return totalRecodes;
	}

	public void setTotalRecodes(Integer totalRecodes) {
		this.totalRecodes = totalRecodes;
	}

	public Integer getTotalPages() {
		if(this.totalRecodes % this.limit ==0) {
			this.totalPages = this.totalRecodes/this.limit;
		}else {
			this.totalPages = this.totalRecodes/this.limit+1;
		}
		return this.totalPages;
	}

	/*public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}*/

	public Integer getBeginPageOffset() {
		this.beginPageOffset = (this.pageNumber-1)*this.limit;
		return beginPageOffset;
	}

	/*public void setBeginPageOffset(Integer beginPageOffset) {
		this.beginPageOffset = beginPageOffset;
	}
*/
	public Integer getLimit() {
		
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	
}
