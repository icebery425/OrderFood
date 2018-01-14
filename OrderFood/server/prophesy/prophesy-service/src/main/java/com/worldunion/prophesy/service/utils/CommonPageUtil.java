package com.worldunion.prophesy.service.utils;

import java.util.List;

import com.worldunion.prophesy.generator.page.PageList;
import com.worldunion.prophesy.generator.page.Paginator;
import com.worldunion.prophesy.generator.page.PagingCriterion;

public class CommonPageUtil {

	public static void generatePageList(int count, PagingCriterion pagingCriterion,PageList resultList, List list){
		Paginator paginator = new Paginator();
		paginator.setCurrentPage(pagingCriterion.getCurrentPage());
		paginator.setPageSize(pagingCriterion.getPageSize() == 0 ? 20 : pagingCriterion.getPageSize());
		
		if(count > 0){
			paginator.setTotalRows(count);//总记录数
			resultList.setList(list);
		} else {
			paginator.setTotalRows(0);//总记录数
		}
		resultList.setPaginator(paginator);
	}
}
