package com.devglan;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.process.DocumentPreprocessor;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Set;

public class TokenizerTest {

    @Test
    public void SentenceDetectorTest() throws IOException {
        StandfordTokenizer tokenizer = new StandfordTokenizer();
        DocumentPreprocessor dp = tokenizer.tokenize("standford.txt");
        Assert.assertTrue(dp != null);
    }

    @Test
    public void SentencePosDetectorTest() throws IOException {
        PTBTokenizerExample tokenizer = new PTBTokenizerExample();
        Set<CoreLabel> labels  = tokenizer.tokenize("C:/D/workspaces/website_new/standfordsetupdemo/src/main/resources/standford.txt");
        Assert.assertTrue(labels != null && labels.size() > 0);
    }

}