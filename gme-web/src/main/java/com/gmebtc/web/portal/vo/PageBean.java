package com.gmebtc.web.portal.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @Project：gme-web   
 * @Class：PageBean   
 * @Description 类描述： 具体的分页参数   
 * @Author：zzh 
 * @Date：2018年6月30日 下午6:19:32   
 * @version v1.0
 */
public class PageBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * currentPage: 当前页
	 */
	private Integer currentPage;
	/**
	 * numPerPage: 每页多少数据
	 */
	private Integer numPerPage;
	/**
	 * totalCount: 总数据量
	 */
	private Integer totalCount;
	/**
	 * pageCount: 一共多少页
	 */
	private Integer pageCount;
	/**
	 * recordList: 查询数据
	 */
	private List recordList;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List getRecordList() {
		return recordList;
	}
	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", numPerPage=" + numPerPage + ", totalCount=" + totalCount
				+ ", pageCount=" + pageCount + ", recordList=" + recordList + "]";
	}
}
