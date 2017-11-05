package name.cdd.train.ddd.selftrain.train_1;

import static name.cdd.train.ddd.selftrain.train_1.framework.Result.successResult;
import static name.cdd.train.ddd.selftrain.train_1.framework.Result.failResult;

import junit.framework.TestCase;
import name.cdd.train.ddd.selftrain.train_1.framework.Result;
import name.cdd.train.ddd.selftrain.train_1.framework.Rule;
import name.cdd.train.ddd.selftrain.train_1.framework.UnaryRule;

public class AtomicRuleTest extends TestCase
{
    private UnaryAtomicRule rule;
    
    @Override
    protected void setUp() throws Exception
    {
        rule = new UnaryAtomicRule((p, x) -> x == 10000f, x -> x, null);
    }
    
    public void testApply_succ()
    {
        Result<Float> result = rule.apply(10000f);
        
        assertEquals(true, result.isSuccess());
        assertEquals(10000f, result.getResult());
    }
    
    public void testApply_fail()
    {
        Result<Float> result = rule.apply(99f);
        
        assertEquals(false, result.isSuccess());
    }
    
    public void testOrElse_succ()
    {
        UnaryRule<Float> r2 = x -> successResult(x - 0.1f);
        Rule<Float, Float> composedRule = rule.orElse(r2);
        
        Result<Float> result = composedRule.apply(10000f);
        
        assertEquals(true, result.isSuccess());
        assertEquals(10000f, result.getResult());
    }
    
    public void testOrElse_fail()
    {
        UnaryRule<Float> r2 = x -> successResult(x - 0.1f);
        UnaryRule<Float> composedRule = rule.orElse(r2);
        
        Result<Float> result = composedRule.apply(99f);
        
        assertEquals(true, result.isSuccess());
        assertEquals(98.9f, result.getResult());
    }
    
    public void testApplyIfSuccess1()
    {
        UnaryRule<Float> r1 = x -> successResult(x - 1f);
        UnaryRule<Float> r2 = x -> successResult(x - 2f);
        UnaryRule<Float> r3 = x -> successResult(x - 3f);
        
        UnaryRule<Float> composedRule = r1.applyIfSuccess(r2).applyIfSuccess(r3);
        
        Result<Float> result = composedRule.apply(99f);
        
        assertEquals(true, result.isSuccess());
        assertEquals(93f, result.getResult());
    }
    
    public void testApplyIfSuccess2()
    {
        UnaryRule<Float> r1 = x -> successResult(x - 1f);
        UnaryRule<Float> r2 = x -> successResult(x - 2f);
        UnaryRule<Float> r3 = x -> failResult();
        
        UnaryRule<Float> composedRule = r1.applyIfSuccess(r2).applyIfSuccess(r3);
        
        Result<Float> result = composedRule.apply(99f);
        
        assertEquals(true, result.isSuccess());
        assertEquals(96f, result.getResult());
    }
    
    public void testApplyIfSuccess3()
    {
        UnaryRule<Float> r1 = x -> successResult(x - 1f);
        UnaryRule<Float> r2 = x -> failResult();
        UnaryRule<Float> r3 = x -> successResult(x - 2f);
        
        UnaryRule<Float> composedRule = r1.applyIfSuccess(r2).applyIfSuccess(r3);
        
        Result<Float> result = composedRule.apply(99f);
        
        assertEquals(true, result.isSuccess());
        assertEquals(96f, result.getResult());
    }
    
    public void testApplyIfSuccess4()
    {
        UnaryRule<Float> r1 = x -> failResult();
        UnaryRule<Float> r2 = x -> successResult(x - 1f);
        UnaryRule<Float> r3 = x -> successResult(x - 2f);
        
        UnaryRule<Float> composedRule = r1.applyIfSuccess(r2).applyIfSuccess(r3);
        
        Result<Float> result = composedRule.apply(99f);
        
        assertEquals(false, result.isSuccess());
    }
}
