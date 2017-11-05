package name.cdd.train.ddd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingProcess
{
    public String processNumbers(int[] inputs)
    {
        List<String> results = processAll(inputs);
        return makeOutput(results);
    }
    
    String processNumber(int input)
    {
        return RuleSpec.getRule().process(input);
    }
    
    private List<String> processAll(int[] inputs)
    {
        List<String> results = new ArrayList<String>();
        
        for(int input : inputs)
        {
            results.add(processNumber(input));
        }
        return results;
    }
    
    private String makeOutput(List<String> results)
    {
        System.out.println(Arrays.toString(results.toArray(new String[0])));
        return Arrays.toString(results.toArray(new String[0]));
    }
}
