package com.worldunion.prophesy.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.worldunion.prophesy.controller.BaseController;
import com.worldunion.prophesy.generator.page.PageList;
import com.worldunion.prophesy.generator.page.PagingCriterion;
import com.worldunion.prophesy.model.account.Group;
import com.worldunion.prophesy.model.account.Resource;
import com.worldunion.prophesy.model.util.Constant;
import com.worldunion.prophesy.service.account.GroupService;
import com.worldunion.prophesy.service.account.ResourceService;
import com.worldunion.prophesy.service.base.SystemControllerLog;
import com.worldunion.prophesy.utils.common.error.Result;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 权限组
 * Created by BAOPING.XU on 2015/11/23.
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private ResourceService resourceService;

    /**
     * 系统管理：权限组管理
     *
     * @return
     */
    @RequestMapping("/list")
    @SystemControllerLog(description = "系统管理：权限组管理",logTypeCode=Constant.LOG_TYPECODE_BUSI,logActionCode=Constant.LOG_ACTION_VIEW_MENU,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="")
    public String list() {
        return "account/group/list";
    }


    /**
     * 列表页面数据
     *
     * @return
     */
    @RequestMapping("/list/data")
    @SystemControllerLog(description = "权限组管理（列表）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="tsm_group")
    @ResponseBody
    public PageList<Group> listData() {
    	Map<String, Object> params = getQueryParams();
	    PagingCriterion pagingCriterion = new PagingCriterion();
	    pagingCriterion.setPageSize(Integer.valueOf(params.get("rows")+""));
	    pagingCriterion.setCurrentPage(Integer.valueOf(params.get("page")+""));
	    PageList<Group> result = groupService.searchByMapPage(pagingCriterion, params);
        return result;
    }

    /**
     * 编辑页面
     *
     * @return
     */
    @RequestMapping("/edit")
    public String editView(String groupId, ModelMap modelMap) {
        modelMap.put("entity", groupService.getGroup(groupId));
        return "account/group/edit";
    }

    /**
     * 新增页面
     *
     * @return
     */
    @RequestMapping("/add")
    public String addView(String groupId, ModelMap modelMap) {
        return "account/group/add";
    }

    @RequestMapping("/add/save")
    @SystemControllerLog(description = "权限组管理（新增分组）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_ADD,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="tsm_group")
    @ResponseBody
    public Result doSave(Group group, String ids) {

        List<Resource> resourcesList = new ArrayList<Resource>();
        if (StringUtils.isNotBlank(ids)) {
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                resourcesList.add(new Resource(id));
            }
        }
        group.setResourcesList(resourcesList);
        this.groupService.saveOrupateGroup(group);
        return Result.OK;


    }


    /**
     * 权限组选中的资源
     *
     * @return
     */
    @RequestMapping("/add/resourceTree")
    @ResponseBody
    public Result resourceTreeView() {
        List<Map<String, Object>> list = resourceService.getSelectedTreeResource(null);
        Map<String, Object> dataMap = new HashMap<>();
        return Result.buildOkResult(list);
    }


    /**
     * 权限组选中的资源
     *
     * @return
     */
    @RequestMapping("/edit/resourceTree")
    @ResponseBody
    public Result resourceTreeView(String groupId) {
        List<Map<String, Object>> list = resourceService.getSelectedTreeResource(groupId);
        Map<String, Object> dataMap = new HashMap<>();
        return Result.buildOkResult(list);
    }

    /**
     * 编辑保存
     */
    @RequestMapping("/edit/save")
    @SystemControllerLog(description = "权限组管理（编辑分组）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_UPDATE,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="tsm_group")
    @ResponseBody
    public Result doEdit(Group group, String ids) {

        List<Resource> resourcesList = new ArrayList<Resource>();

        if (StringUtils.isNotBlank(ids)) {
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                resourcesList.add(new Resource(id));
            }
        }

        group.setResourcesList(resourcesList);
        this.groupService.saveOrupateGroup(group);

        return Result.OK;


    }


    /**
     * 删除
     *
     * @return
     */
    @RequestMapping("/delete")
    @SystemControllerLog(description = "权限组管理（删除分组）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_DELETE,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_PERMISSIONGROUP,tableName="tsm_group")
    @ResponseBody
    public Result deleteGroup(String groupId) {
        groupService.deleteById(groupId);
        return Result.buildOkResult();
    }


}
