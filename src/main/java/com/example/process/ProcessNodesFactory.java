package com.example.process;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 流程编排工厂
 */
@Component
@Slf4j
public class ProcessNodesFactory implements ApplicationContextAware {

    /**
     * 流程名称->流程节点（名称）列表的映射
     */
    private ListMultimap<String, Node> operation2Nodes = LinkedListMultimap.create();

    /**
     * 节点名称->节点 bean 实例的映射
     */
    private Map<String, Node> name2Node = Maps.newHashMap();

    /**
     * 通过流程名称获取流程节点（实例）
     */
    public List<Node> get(String opeartion) {
        return operation2Nodes.get(opeartion);
    }

    @Value("classpath:process/nodes.json")
    private Resource nodesJson;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("[节点工厂]开始加载流程节点编排");

        // 维护一个节点名到节点 bean 的集合
        Map<String, Node> beansOfType = applicationContext.getBeansOfType(Node.class);
        beansOfType.values().forEach(node -> {
            String nodeName = node.getNodeName();
            if (name2Node.containsKey(nodeName)) {
                throw new RuntimeException("[节点工厂]节点名称出现重复："+nodeName);
            }
            name2Node.put(nodeName, node);
        });

        // 解析节点编排文件
        String jsonStr = null;
        try {
            File file = nodesJson.getFile();
            jsonStr = FileUtils.readFileToString(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<OperationAndNodes> operationAndNodesList = JSON.parseArray(jsonStr, OperationAndNodes.class);
        // 注册节点编排
        for (OperationAndNodes operationAndNodes : operationAndNodesList) {
            for (String nodeName : operationAndNodes.nodeList) {
                Node node = name2Node.get(nodeName);
                if (Objects.isNull(node)) {
                    throw new RuntimeException("[节点工厂]请定义节点：" + nodeName);
                }
                operation2Nodes.put(operationAndNodes.operation, node);
            }
        }
        log.info("[节点工厂] 加载完毕，所有编排为:{0}", JSON.toJSONString(operation2Nodes.asMap()));
    }

    @Data
    public static class OperationAndNodes {
        /**
         * 流程名称
         */
        private String operation;
        /**
         * 流程节点列表
         */
        private List<String> nodeList;
    }
}
