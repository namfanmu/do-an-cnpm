package com.cnpm.api.output;

import java.util.ArrayList;
import java.util.List;

import com.cnpm.dto.PostDTO;

public class PostOutput {

	private int page;
	private int totalPage;
	

	private List<PostDTO> listResultDTO = new ArrayList<>();

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	

	public List<PostDTO> getListResultDTO() {
		return listResultDTO;
	}

	public void setListResultDTO(List<PostDTO> listResultDTO) {
		this.listResultDTO = listResultDTO;
	}

}
