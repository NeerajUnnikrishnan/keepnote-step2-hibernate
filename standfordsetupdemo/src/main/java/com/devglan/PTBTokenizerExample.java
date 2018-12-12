package com.devglan;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class PTBTokenizerExample {

    public Set<CoreLabel> tokenize(String fileName) throws FileNotFoundException {
        Set<CoreLabel> labels = new HashSet<>();
        PTBTokenizer<CoreLabel> ptbt = new PTBTokenizer<>(new FileReader(fileName),
                new CoreLabelTokenFactory(), "");
        while (ptbt.hasNext()) {
            CoreLabel label = ptbt.next();
            System.out.print(label);
            labels.add(label);
        }
        return labels;
    }

}
