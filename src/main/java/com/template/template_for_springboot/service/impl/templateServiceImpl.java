package com.template.template_for_springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.template.template_for_springboot.entity.WebMessage;
import com.template.template_for_springboot.entity.WebMessageExample;
import com.template.template_for_springboot.mapper.WebMessageMapper;
import com.template.template_for_springboot.service.templateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xuwei
 * @create 2023-03-02 17:49
 */
@Service
public class templateServiceImpl implements templateService {
    @Resource
    private WebMessageMapper webMessageMapper;

    @Override
    public PageInfo<WebMessage> getTemplatePage(Integer pageNum, Integer pageSize, WebMessage search) {
        //开启分页功能 设置当前页为pageNum，页数为pageSize
        PageHelper.startPage(pageNum, pageSize);
        //设置5个导航分页，根据需求设计。同时根据条件search需要查询数据，赋值到下面的第一个参数，类型为List结果集
        WebMessageExample example = new WebMessageExample();
        example.createCriteria().andWebnameIsNotNull();
        return new PageInfo<>(webMessageMapper.selectByExample(example), 5);
    }

    @Override
    public String saveTemplateMessage(WebMessage template) {
        webMessageMapper.insertSelective(template);
        return "插入成功";
    }
}
