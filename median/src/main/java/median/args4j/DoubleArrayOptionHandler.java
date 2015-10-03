package median.args4j;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.OptionHandler;
import org.kohsuke.args4j.spi.Parameters;
import org.kohsuke.args4j.spi.Setter;

public class DoubleArrayOptionHandler extends OptionHandler<Double> {

    public DoubleArrayOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super Double> setter) {
        super(parser, option, setter);
    }

    @Override
    public int parseArguments(Parameters params) throws CmdLineException {
        int counter = 0;
        for (; counter < params.size(); counter++) {
            String param = params.getParameter(counter);

            if (param.startsWith("-")) {
                break;
            }

            for (String p : param.split(" ")) {
                setter.addValue(Double.valueOf(p));
            }
        }

        return counter;
    }

    @Override
    public String getDefaultMetaVariable() {
        return "DOUBLE[]";
    }
}
