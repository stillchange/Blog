package com.blog.action.critique;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.blog.entity.Critique;
import com.blog.service.CritiqueService;

@Controller@Scope("prototype")
public class MessageShowAction {
	@Resource CritiqueService critiqueServiceImpl;
	private List<Critique> critiques;
	private int totalPage;
	private int page=1;
	private int pageSize; 
	private int size;
	
	public String execute(){
		size = critiqueServiceImpl.getSize("留言");
		totalPage = size%pageSize==0?size/pageSize:size/pageSize+1;
		critiques = critiqueServiceImpl.getCritiquesByType("留言", (page-1)*pageSize, pageSize);
		return "success";
	}

	public List<Critique> getCritiques() {
		return critiques;
	}

	public void setCritiques(List<Critique> critiques) {
		this.critiques = critiques;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

}
