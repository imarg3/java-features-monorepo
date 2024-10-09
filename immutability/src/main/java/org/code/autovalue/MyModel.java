package org.code.autovalue;

import com.google.auto.value.AutoValue;

import java.util.List;
import java.util.Optional;

@AutoValue
public abstract class MyModel {
    public abstract Optional<Integer> myOptional();

    public abstract String myString();

    public abstract List<String> myList();

    // Builder not generated by default
    // We have to write this boilerplate code
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setMyOptional(Optional<Integer> myOptional);

        public abstract Builder setMyString(String myString);

        public abstract Builder setMyList(List<String> myList);

        public abstract MyModel build();
    }
}
