package name.cdd.train.ddd.class_2;

import junit.framework.TestCase;
import static name.cdd.train.ddd.class_2.SpecTool.*;

public class RuleTest extends TestCase
{
    public void test_rule_r1_3()
    {
        AtomicRule rule_r1_3 = atom(times(3), toFizz());

        assertResult(Result.succeededResult("Fizz"), rule_r1_3.apply(3));
        assertResult(Result.succeededResult("Fizz"), rule_r1_3.apply(6));
        assertResult(Result.failedResult(), rule_r1_3.apply(4));
    }

    public void test_rule_r1_5()
    {
        AtomicRule rule_r1_5 = atom(times(5), toBuzz());

        assertResult(Result.succeededResult("Buzz"), rule_r1_5.apply(5));
        assertResult(Result.succeededResult("Buzz"), rule_r1_5.apply(10));
        assertResult(Result.failedResult(), rule_r1_5.apply(4));
    }

    public void test_rule_r1_7()
    {
        AtomicRule rule_r1_7 = atom(times(7), toWhizz());

        assertResult(Result.succeededResult("Whizz"), rule_r1_7.apply(7));
        assertResult(Result.succeededResult("Whizz"), rule_r1_7.apply(14));
        assertResult(Result.failedResult(), rule_r1_7.apply(4));
    }

    public void test_or()
    {
        AtomicRule rule_r1_3 = atom(times(3), toFizz());
        AtomicRule rule_r1_5 = atom(times(5), toBuzz());
        Rule or = or(rule_r1_3, rule_r1_5);
        
        assertResult(Result.failedResult(), or.apply(1));
        assertResult(Result.succeededResult("Fizz"), or.apply(3));
        assertResult(Result.succeededResult("Buzz"), or.apply(5));
        assertResult(Result.succeededResult("Fizz"), or.apply(15));
    }
    
    public void test_or3()
    {
        Rule rule_r1_3 = atom(times(3), toFizz());
        Rule rule_r1_5 = atom(times(5), toBuzz());
        Rule rule_r1_7 = atom(times(7), toWhizz());
        
        Rule or = or(rule_r1_3, rule_r1_5, rule_r1_7);
        
        assertResult(Result.failedResult(), or.apply(1));
        assertResult(Result.succeededResult("Fizz"), or.apply(3));
        assertResult(Result.succeededResult("Buzz"), or.apply(5));
        assertResult(Result.succeededResult("Whizz"), or.apply(7));
        assertResult(Result.succeededResult("Fizz"), or.apply(15));
        assertResult(Result.succeededResult("Buzz"), or.apply(35));
    }
    
    public void test_and()
    {
        Rule rule_r1_3 = atom(times(3), toFizz());
        Rule rule_r1_5 = atom(times(5), toBuzz());
        
        Rule and = and(rule_r1_3, rule_r1_5);
        
        assertResult(Result.failedResult(), and.apply(3));
        assertResult(Result.failedResult(), and.apply(5));
        assertResult(Result.succeededResult("FizzBuzz"), and.apply(15));
    }
    
    public void test_and3()
    {
        Rule rule_r1_3 = atom(times(3), toFizz());
        Rule rule_r1_5 = atom(times(5), toBuzz());
        Rule rule_r1_7 = atom(times(7), toWhizz());
        
        Rule and = and(rule_r1_3, rule_r1_5, rule_r1_7);
        
        assertResult(Result.failedResult(), and.apply(3));
        assertResult(Result.failedResult(), and.apply(15));
        assertResult(Result.succeededResult("FizzBuzzWhizz"), and.apply(105));
    }
    
    public void test_r2()
    {
        Rule r1_3 = atom(times(3), toFizz());
        Rule r1_5 = atom(times(5), toBuzz());
        Rule r1_7 = atom(times(7), toWhizz());
        
        Rule r2 = or(and(r1_3, r1_5, r1_7),
                       and(r1_3, r1_5),
                       and(r1_3, r1_7),
                       and(r1_5, r1_7));
        
        assertResult(Result.succeededResult("FizzBuzzWhizz"), r2.apply(105));
        assertResult(Result.succeededResult("FizzBuzz"), r2.apply(15));
        assertResult(Result.succeededResult("FizzWhizz"), r2.apply(21));
        assertResult(Result.succeededResult("BuzzWhizz"), r2.apply(35));
        assertResult(Result.failedResult(), r2.apply(3));
    }
    
    public void test_r3()
    {
        Rule r3 = atom(contains(3), toFizz());
        assertResult(Result.failedResult(), r3.apply(105));
        assertResult(Result.succeededResult("Fizz"), r3.apply(135));
    }
    
    public void test_rd()
    {
        Rule rd = atom(alwaysTrue(), defaultAction());
        assertResult(Result.succeededResult("2"), rd.apply(2));
    }
    
    public void test_spec()
    {
        Rule r1_3 = atom(times(3), toFizz());
        Rule r1_5 = atom(times(5), toBuzz());
        Rule r1_7 = atom(times(7), toWhizz());
        
        Rule r1 = or(r1_3, r1_5, r1_7);
        
        Rule r2 = or(and(r1_3, r1_5, r1_7),
                       and(r1_3, r1_5),
                       and(r1_3, r1_7),
                       and(r1_5, r1_7));
        
        Rule r3 = atom(contains(3), toFizz());
        Rule rd = atom(alwaysTrue(), defaultAction());
        
        Rule spec = or(r3, r2, r1, rd);
        
        assertResult(Result.succeededResult("1"), spec.apply(1));
        assertResult(Result.succeededResult("Whizz"), spec.apply(7));
        assertResult(Result.succeededResult("Buzz"), spec.apply(25));
        assertResult(Result.succeededResult("Whizz"), spec.apply(28));
        assertResult(Result.succeededResult("Fizz"), spec.apply(35));
        assertResult(Result.succeededResult("FizzBuzzWhizz"), spec.apply(105));
    }
    
    private void assertResult(Result expected, Result actual)
    {
        assertEquals(expected.isSuccess(), actual.isSuccess());
        assertEquals(expected.getStr(), actual.getStr());
    }
    
    /************************* 以下为作业 *********************************/
    
    public void test_spec_exercise()
    {
        Rule r1_3 = atom(times(3), toFizz());
        Rule r1_5 = atom(times(5), toBuzz());
        Rule r1_7 = atom(times(7), toWhizz());
        Rule r1_8 = atom(times(8), toHazz());
        
        Rule r1 = or(r1_3, r1_5, r1_7, r1_8);
        
        Rule r2 = or(and(r1_3, r1_5, r1_7, r1_8),
                     and(r1_5, r1_7, r1_8),
                     and(r1_3, r1_7, r1_8),
                     and(r1_3, r1_5, r1_8),
                     and(r1_3, r1_5, r1_7),
                     and(r1_3, r1_5),
                     and(r1_3, r1_7),
                     and(r1_3, r1_8),
                     and(r1_5, r1_7),
                     and(r1_5, r1_8),
                     and(r1_7, r1_8));
        
        Rule r3 = atom(contains(3), toFizz());
        Rule rd = atom(alwaysTrue(), defaultAction());
        
        Rule spec = or(r3, r2, r1, rd);
        
        assertResult(Result.succeededResult("1"), spec.apply(1));
        assertResult(Result.succeededResult("Whizz"), spec.apply(7));
        assertResult(Result.succeededResult("Hazz"), spec.apply(8));
        assertResult(Result.succeededResult("Buzz"), spec.apply(25));
        assertResult(Result.succeededResult("Whizz"), spec.apply(28));
        assertResult(Result.succeededResult("Fizz"), spec.apply(35));
        assertResult(Result.succeededResult("WhizzHazz"), spec.apply(56));
        assertResult(Result.succeededResult("FizzBuzzWhizz"), spec.apply(105));
        assertResult(Result.succeededResult("FizzBuzzWhizzHazz"), spec.apply(840));
    }

}
