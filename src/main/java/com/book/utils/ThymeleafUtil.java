package com.book.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.Writer;

public class ThymeleafUtil {

    public static final TemplateEngine engine;
    static {
        engine = new TemplateEngine();
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setCharacterEncoding("UTF-8");
        engine.setTemplateResolver(resolver);
    }

    public static void process(String template, IContext context, Writer writer){
        engine.process(template, context, writer);
    }

}
