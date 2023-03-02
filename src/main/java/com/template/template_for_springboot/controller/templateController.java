package com.template.template_for_springboot.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageInfo;
import com.template.template_for_springboot.entity.WebMessage;
import com.template.template_for_springboot.service.templateService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author xuwei
 * @create 2023-03-02 17:47
 */
@Controller
public class templateController {

    @Autowired
    private templateService templateService;

    /**
     * 分页查询信息
     *
     * @param pageNum  页面num
     * @param pageSize 页面大小
     * @param search   搜索条件
     * @return {@link PageInfo}<{@link WebMessage}>
     */
    @ResponseBody
    @PostMapping("/template/view")
    public PageInfo<WebMessage> getTemplateMessageByPageInfo(@RequestParam(defaultValue = "1") Integer pageNum,
                                                             @RequestParam(defaultValue = "10") Integer pageSize,
                                                             @RequestBody WebMessage search) {
        return templateService.getTemplatePage(pageNum, pageSize, search);
    }

    /**
     * 添加信息
     *
     * @param template 模板
     * @return {@link String}
     */
    @ResponseBody
    @PostMapping("/template/save")
    public String saveTemplateMessage(@RequestBody WebMessage template) {
        return templateService.saveTemplateMessage(template);
    }


}
