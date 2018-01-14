package com.worldunion.prophesy.controller.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.worldunion.prophesy.model.account.Resource;
import com.worldunion.prophesy.model.util.Constant;
import com.worldunion.prophesy.service.account.ResourceService;
import com.worldunion.prophesy.service.base.SystemControllerLog;
import com.worldunion.prophesy.utils.common.error.Result;

/**
 * 菜单资源管理
 * Created by starhousexq on 2015/11/23.
 */
@Controller
@RequestMapping("/account/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 系统管理：菜单资源管理
     *
     * @return
     */
    @RequestMapping("/list")
    @SystemControllerLog(description = "系统管理：菜单资源管理",logTypeCode=Constant.LOG_TYPECODE_BUSI,logActionCode=Constant.LOG_ACTION_VIEW_MENU,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_MENU,tableName="")
    public String list() {
        return "account/resource/list";
    }

    /**
     * 列表数据
     *
     * @return
     */
    @RequestMapping("/list/data")
    @SystemControllerLog(description = "菜单资源管理（列表）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_VIEW,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_MENU,tableName="tsm_resource")
    @ResponseBody
    public Result listData() {
        return Result.buildOkResult(resourceService.getTreeResource());
    }

    @RequestMapping("/delete")
    @SystemControllerLog(description = "菜单资源管理（删除菜单）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_DELETE,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_MENU,tableName="tsm_resource")
    @ResponseBody
    public Result delete(String ids) {
        resourceService.deleteResources(ids);
        return Result.buildOkResult();
    }


    @RequestMapping("/add")
    public String addPage(ModelMap modelMap) {
        modelMap.addAttribute("resourcesList", resourceService.getResources());
        return "account/resource/add";
    }

    @RequestMapping("/add/save")
    @ResponseBody
    public Result add(Resource resource) {
        resourceService.saveOrUpdateResource(resource);
        return Result.OK;
    }


    @RequestMapping("/edit")
    public String edit(String id, ModelMap modelMap) {
        modelMap.addAttribute("resourcesList", resourceService.getIgnoreResources(id));
        modelMap.put("entity", this.resourceService.getResource(id));
        return "account/resource/edit";
    }

    @RequestMapping("/edit/save")
    @SystemControllerLog(description = "菜单资源管理（编辑菜单）",logTypeCode=Constant.LOG_TYPECODE_SYS,logActionCode=Constant.LOG_ACTION_ADD,funcCode=Constant.LOG_FUNC_SYSTEMMANAGER_MENU,tableName="tsm_resource")
    @ResponseBody
    public Result doEdit(Resource resource) {
        resourceService.saveOrUpdateResource(resource);
        return Result.OK;
    }

}
