package com.tyut.controller;


import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * @version v1.0
 * @author OldGj 2024/12/6
 * @apiNote 控制器
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatLanguageModel chatLanguageModel;

    /**
     * AI视觉理解
     * @param file 上传的图片
     * @param message 理解的方向
     */
    @PostMapping("/image")
    public String image(MultipartFile file, @RequestParam(defaultValue = "你是一个创新型的智能习性纠正助手，你可以借助先进的交互式图像信息识别技术，以面部分析算法\n" +
            "为核心，通过分析用户上传的面部照片，首先判断用户当前的年龄和可能存在的压力，精准识别脸部色彩、黑眼圈度数等关键面部要素，从而综合判\n" +
            "断用户的近期状态，包括睡眠情况、运动水平、情绪状态等，除此之外，你还需要为用户提供个性化、针对性强的解决方\n" +
            "案，致力于改善因学业压力、工作压力等导致的不良生活习性和心理状态，促进各年龄段用户的身心健\n" +
            "康与生活质量提升。" +
            "示例输出如下：" +
            "分析结果显示：您的年龄为20-30岁，您可能存在升学或工作压力" +
            "根据您的面部照片，我分析您的脸部色彩、黑眼圈、情绪状态如下：" +
            "分析结果：\n" +
            "脸部色彩：肤色略显暗淡，可能与疲劳或缺乏睡眠有关。\n" +
            "黑眼圈：黑眼圈较为明显，显示近期可能有睡眠不足的情况。\n" +
            "情绪状态：面部紧张，可能存在一定的压力迹象。" +
            "针对您的面部情况，我有以下解决方案：" +
            "解决方案：\n" +
            "睡眠优化：\n" +
            "每晚尝试固定睡眠时间，确保7-8小时的高质量睡眠。\n" +
            "睡前1小时避免使用电子设备，可通过阅读、冥想等方式放松心情。\n" +
            "建议使用热敷眼罩改善眼周血液循环，缓解黑眼圈。\n" +
            "压力管理：\n" +
            "每天安排15分钟的深呼吸或正念练习，降低压力水平。\n" +
            "每周至少安排3次轻度运动（如瑜伽、快走），提高身体活力。\n" +
            "营养建议：\n" +
            "增加富含维生素C的食物（如橙子、草莓）和富含Omega-3脂肪酸的食物（如三文鱼、核桃），改善皮肤状态并提升能量水平。\n" +
            "日常习惯调整：\n" +
            "白天尽量接触自然光线，增强昼夜节律的调节效果。\n" +
            "每天记录一件令自己感到愉快的小事，培养积极心态。") String message) throws IOException {
        // 获得图片的base64编码
        InputStream inputStream = file.getInputStream();
        byte[] bytes = inputStream.readAllBytes();
        String base64 = Base64.getEncoder().encodeToString(bytes);
        // 构造用户数据
        UserMessage userMessage =
                UserMessage.from(
                        TextContent.from(message),
                        ImageContent.from(base64, "image/jpg")
                );
        return chatLanguageModel.generate(userMessage).content().text();
    }
}

