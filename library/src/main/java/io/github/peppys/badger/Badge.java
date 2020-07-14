package io.github.peppys.badger;

import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

@AutoValue
abstract class Badge {
    public abstract String labelText();

    public abstract String labelColor();

    public abstract String messageText();

    public abstract String messageColor();

    static Builder builder() {
        return new AutoValue_Badge.Builder();
    }

    String getRawSVG() {
        return "hi";
    }

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder setLabelText(String value);

        abstract Builder setLabelColor(String value);

        abstract Builder setMessageText(String value);

        abstract Builder setMessageColor(String value);

        abstract Badge autoBuild();

        Badge build() {
            Badge badge = autoBuild();

            Preconditions.checkState(!Strings.isNullOrEmpty(badge.labelText()), "Label text cannot be empty");
            Preconditions.checkState(!Strings.isNullOrEmpty(badge.labelColor()), "Label color cannot be empty");
            Preconditions.checkState(!Strings.isNullOrEmpty(badge.messageText()), "Message text cannot be empty");
            Preconditions.checkState(!Strings.isNullOrEmpty(badge.messageColor()), "Message color cannot be empty");

            return badge;
        }
    }
}
