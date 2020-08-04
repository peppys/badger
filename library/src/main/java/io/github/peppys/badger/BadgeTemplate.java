package io.github.peppys.badger;

import freemarker.core.XMLOutputFormat;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

class BadgeTemplate {
    private static final String DEFAULT_TEMPLATE = "badge-svg.ftl";

    private static Configuration config = initializeConfig();

    private static Configuration initializeConfig() {
        Configuration config = new Configuration(new Version(2, 3, 20));
        config.setDefaultEncoding("UTF-8");
        config.setClassForTemplateLoading(BadgeTemplate.class, "/templates/");
        config.setLocale(Locale.US);
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        config.setOutputFormat(XMLOutputFormat.INSTANCE);

        return config;
    }

    static String render(Map<String, Object> data) throws IOException, TemplateException {
        Writer writer = new StringWriter();

        config.getTemplate(DEFAULT_TEMPLATE).process(data, writer);

        return writer.toString();
    }
}
