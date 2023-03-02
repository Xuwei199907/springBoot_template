package com.template.template_for_springboot.service;

import com.github.pagehelper.PageInfo;
import com.template.template_for_springboot.entity.WebMessage;

/**
 * @author xuwei
 * @create 2023-03-02 17:49
 */
public interface templateService {

    PageInfo<WebMessage> getTemplatePage(Integer pageNum, Integer pageSize, WebMessage search);

    String saveTemplateMessage(WebMessage template);
}
