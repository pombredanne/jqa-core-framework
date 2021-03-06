package com.buschmais.jqassistant.core.rule.api.matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import com.buschmais.jqassistant.core.rule.api.source.RuleSource;

public class RuleSourceMatcher extends TypeSafeMatcher<RuleSource> {

    private final String ruleSourceId;

    private RuleSourceMatcher(String id) {
        ruleSourceId = id;
    }

    @Override
    protected boolean matchesSafely(RuleSource ruleSource) {
        return ruleSourceId.equals(ruleSource.getId());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(ruleSourceId);
    }

    @Override
    protected void describeMismatchSafely(RuleSource item, Description mismatchDescription) {
        mismatchDescription.appendText(item.getId());
    }

    public static Matcher<RuleSource> matchesById(String id) {
        return new RuleSourceMatcher(id);
    }
}
