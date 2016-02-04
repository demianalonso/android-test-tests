package com.count.phrases.domain;

import android.support.annotation.NonNull;
import static com.count.phrases.domain.BusinessException.*;

public class Counter {

    @NonNull
    public String processText(CharSequence text) {
        assertNotNull(text, "Cannot count null characters");

        int phraseCharCount = text.length();

        assertTrue(phraseCharCount > 0, "I cannot count no characters");

        return phraseCharCount + " letters";
    }
}
