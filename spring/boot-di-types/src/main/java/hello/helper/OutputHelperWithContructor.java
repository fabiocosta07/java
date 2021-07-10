package hello.helper;

import hello.generator.IOutputGenerator;

public class OutputHelperWithContructor {
    private IOutputGenerator outputGenerator;

    public OutputHelperWithContructor(IOutputGenerator outputGenerator) {
        this.outputGenerator = outputGenerator;
    }
}
