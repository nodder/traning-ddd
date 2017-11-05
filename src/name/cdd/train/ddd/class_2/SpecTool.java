package name.cdd.train.ddd.class_2;

import java.util.Arrays;

import name.cdd.train.ddd.class_1.ListOper;
import name.cdd.train.ddd.class_1.ListOper.Combiner;


public class SpecTool
{
    public static Predication times(int factor)
    {
        return new Times(factor);
    }
    
    public static Predication contains(int factor)
    {
        return new Contains(factor);
    }
    
    public static Predication alwaysTrue()
    {
        return new AlwaysTrue();
    }
    
    public static Action toFizz()
    {
        return new ToFizz();
    }
    
    public static Action toBuzz()
    {
        return new ToBuzz();
    }
    
    public static Action toWhizz()
    {
        return new ToWhizz();
    }
    
    public static Action toHazz()
    {
        return new ToHazz();
    }
    
    public static Action defaultAction()
    {
        return new DefaultAction();
    }
    
    public static AtomicRule atom(Predication pred, Action action)
    {
        return new AtomicRule(pred, action);
    }
    
    public static Rule or(Rule...rules)
    {
        return ListOper.foldl(new Combiner<Rule, Rule>()
        {
            @Override
            public Rule combine(Rule acc, Rule ele)
            {
                return new Or(acc ,ele);
            }

        }, alwaysFailRule(), Arrays.asList(rules));
    }
    
    public static Rule and(Rule... rules)
    {
        return ListOper.foldl(new Combiner<Rule, Rule>()
        {
            @Override
            public Rule combine(Rule acc, Rule ele)
            {
                return new And(acc ,ele);
            }

        }, alwaysSuccessRule(), Arrays.asList(rules));
    }

    private static Rule alwaysSuccessRule()
    {
        return new Rule() {
            @Override
            public Result apply(int i)
            {
                return Result.succeededResult("");
            }};
    }
    
    private static Rule alwaysFailRule()
    {
        return new Rule() {
            @Override
            public Result apply(int i)
            {
                return Result.failedResult();
            }};
    }
    
    //±£¡Ùfor—› æ
//  public static Rule and(Rule... rules)
//  {
//      Rule result = rules[0];
//      
//      for(int i = 1; i < rules.length; i++)
//      {
//          result = new And(result ,rules[i]);
//      }
//      
//      return result;
//  }
}
