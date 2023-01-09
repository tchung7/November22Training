package JSONSerializer;

import java.util.ArrayList;
import java.util.List;

public class Users {
	private String page;
	private String per_page;
	private String total;
	private String total_pages;
	private List<Data> data = new ArrayList<Data>();
	private Support support;

	public String getPage() {
		return this.page;
	}

	public String getPerPage() {
		return this.per_page;
	}

	public String getTotal() {
		return this.total;
	}

	public String getTotalPages() {
		return this.total_pages;
	}

	public List<Data> getData() {
		return this.data;
	}

	public Support getSupport() {
		return this.support;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void setPer_page(String per_page) {
		this.per_page = per_page;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public void setTotal_pages(String total_pages) {
		this.total_pages = total_pages;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public void setSupport(Support support) {
		this.support = support;
	}
}
