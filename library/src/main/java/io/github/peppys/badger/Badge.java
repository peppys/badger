package io.github.peppys.badger;

import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import freemarker.template.TemplateException;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@AutoValue
public abstract class Badge {
    private static final PDFont FONT_FACE = PDMMType1Font.HELVETICA_BOLD;
    private static final int FONT_SIZE = 12;

    private float labelWidth() throws IOException {
        return calculateWidth(labelText());
    }

    private float messageWidth() throws IOException {
        return calculateWidth(messageText());
    }

    private float calculateWidth(String str) throws IOException {
        return FONT_FACE.getStringWidth(str) / 1000 * FONT_SIZE + 10.0f;
    }

    public String render() throws IOException, TemplateException {
        return BadgeTemplate.render(toJSON());
    }

    private Map<String, Object> toJSON() throws IOException {
        return new HashMap<String, Object>() {{
            put("label_width", labelWidth());
            put("label_text", labelText());
            put("label_color", labelColor());
            put("message_width", messageWidth());
            put("message_text", messageText());
            put("message_color", messageColor());
        }};
    }

    abstract String labelText();

    abstract String labelColor();

    abstract String messageText();

    abstract String messageColor();

    public static Builder builder() {
        return new AutoValue_Badge.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        public abstract Builder setLabelText(String value);

        public abstract Builder setLabelColor(String value);

        public abstract Builder setMessageText(String value);

        public abstract Builder setMessageColor(String value);

        public abstract Badge autoBuild();

        public Badge build() {
            Badge badge = autoBuild();

            Preconditions.checkState(!Strings.isNullOrEmpty(badge.labelText()), "Label text cannot be empty");
            Preconditions.checkState(!Strings.isNullOrEmpty(badge.labelColor()), "Label color cannot be empty");
            Preconditions.checkState(!Strings.isNullOrEmpty(badge.messageText()), "Message text cannot be empty");
            Preconditions.checkState(!Strings.isNullOrEmpty(badge.messageColor()), "Message color cannot be empty");

            return badge;
        }
    }
}
