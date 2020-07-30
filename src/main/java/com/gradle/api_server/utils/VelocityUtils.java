package com.gradle.api_server.utils;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;

/**
 * Velocity工具类
 *
 * Created by DIAN on 2019/9/5.
 */
public class VelocityUtils {
    private static final Logger LOG = LoggerFactory.getLogger(VelocityUtils.class);
    private static VelocityEngine velocityEngine = null;

    public static String buildString(VelocityContext context, String template){
        StringWriter stringWriter = new StringWriter();
        velocityEngine.evaluate(context, stringWriter, "", template);
        return stringWriter.toString();
    }

    public static void initVelocityEngine(){
        if(velocityEngine == null){
            synchronized (VelocityUtils.class){
                if(velocityEngine == null){
                    LOG.info("========= init VelocityEngine start ==========");
                    velocityEngine = new VelocityEngine();
                    velocityEngine.init();
                    LOG.info("========= init VelocityEngine finish ==========");
                }
            }
        }
    }
}
