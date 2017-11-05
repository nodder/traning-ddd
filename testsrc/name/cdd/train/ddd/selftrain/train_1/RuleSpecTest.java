package name.cdd.train.ddd.selftrain.train_1;

import static name.cdd.train.ddd.selftrain.train_1.UnaryParams.CardType.ALCH;
import static name.cdd.train.ddd.selftrain.train_1.UnaryParams.CardType.ALCI;
import static name.cdd.train.ddd.selftrain.train_1.framework.Result.successResult;

import java.util.function.Predicate;

import junit.framework.TestCase;
import name.cdd.train.ddd.selftrain.train_1.UnaryParams.CardType;
import name.cdd.train.ddd.selftrain.train_1.framework.Result;
import name.cdd.train.ddd.selftrain.train_1.framework.Rule;
import name.cdd.train.ddd.selftrain.train_1.framework.UnaryRule;

public class RuleSpecTest extends TestCase
{
    private static final float INFINITE_RESISTANT = 10000;
    
    public void testRab()
    {
        UnaryParams ap = new UnaryParams(true, CardType.Other);
        
        UnaryAtomicRule r1 = new UnaryAtomicRule((p, x) -> x==INFINITE_RESISTANT, x -> x, ap);
        UnaryRule<Float> r2 = x -> successResult(x - 0.1f);
        UnaryAtomicRule r3 = new UnaryAtomicRule((p, x) -> p.isEconRelay, x -> x - 0.8f, ap);
        
        Rule<Float, Float> rule = r1.orElse(r2.applyIfSuccess(r3));
        
        Result<Float> result = rule.apply(INFINITE_RESISTANT);
        assertEquals(true, result.isSuccess());
        assertEquals(INFINITE_RESISTANT, result.getResult());
        
        result = rule.apply(10f);
        assertEquals(true, result.isSuccess());
        assertEquals(10f - 0.1f - 0.8f, result.getResult());//TODO
        
        ap.isEconRelay = false;
        result = rule.apply(10f);
        assertEquals(true, result.isSuccess());
        assertEquals(9.9f, result.getResult());
    }
    
    public void testRbg()
    {
        UnaryParams ap = new UnaryParams(true, CardType.Other);
        UnaryAtomicRule r1 = new UnaryAtomicRule(
            (p, x) -> x > 50 && !p.cardType.equals(ALCI) && p.isEconRelay, x -> INFINITE_RESISTANT, ap);
        
        UnaryAtomicRule r2 = new UnaryAtomicRule((p, x) -> x==INFINITE_RESISTANT, x -> x, ap);
        UnaryRule<Float> r3 = x -> successResult(x - 0.05f);
        UnaryAtomicRule r4 = new UnaryAtomicRule(
            (p, x) -> !(p.cardType.equals(ALCI)) && p.isEconRelay, x -> x - 0.8f, ap);
        UnaryAtomicRule r5 = new UnaryAtomicRule(
            (p, x) -> p.cardType.equals(ALCI), x -> 1f/x - 1f/425, ap);
        
        UnaryAtomicRule r6 = new UnaryAtomicRule(
            (p, x) -> x < 0, x -> INFINITE_RESISTANT, ap);
        
        UnaryRule<Float> r7 = x -> successResult(1/x - 0.8f);
        
        UnaryRule<Float> rule = r1.orElse(
                       r2.orElse(r3.applyIfSuccess(r4).applyIfSuccess(r5.applyIfSuccess(r6.orElse(r7)))));
        
        Result<Float> result = rule.apply(INFINITE_RESISTANT);
        assertEquals(true, result.isSuccess());
        assertEquals(INFINITE_RESISTANT, result.getResult());
        
        result = rule.apply(51f);
        assertEquals(true, result.isSuccess());
        assertEquals(INFINITE_RESISTANT, result.getResult());
        
        result = rule.apply(1f);
        assertEquals(true, result.isSuccess());
        assertEquals(1 - 0.05f - 0.8f, result.getResult());
        
        ap.cardType = ALCI;
        result = rule.apply(400f);
        assertEquals(true, result.isSuccess());
        assertEquals(1f/(1f/(400 - 0.05f) - 1f/425) - 0.8f, result.getResult());
        
        result = rule.apply(500f);
        assertEquals(true, result.isSuccess());
        assertEquals(INFINITE_RESISTANT, result.getResult());
    }
    
    
    public void testComprehensiveCompensation()
    {
        Predicate<ResistorCompParam> p0 = p -> p.cardType.equals(ALCI) ||  p.cardType.equals(ALCH);
        Predicate<ResistorCompParam> p1 = p -> p.rab < 10f;
        Predicate<ResistorCompParam> p2 = p -> p.rag < 10f;
        Predicate<ResistorCompParam> p3 = p -> p.rbg < 10f;
        
        Predicate<ResistorCompParam> pRab = p0.and(p1.negate()).and(p2.or(p3)); 
        
        Rule<Float[], Float> ruleRab = new ResistorCompAtomicRule(pRab, x -> INFINITE_RESISTANT, ALCI).orElse(x -> successResult(x[0]));
        
        Result<Float> result = ruleRab.apply(new Float[] {10f, 11f, 12f});
        assertEquals(true, result.isSuccess());
        assertEquals(10f, result.getResult());
        
        result = ruleRab.apply(new Float[] {11f, 9f, 9f});
        assertEquals(true, result.isSuccess());
        assertEquals(INFINITE_RESISTANT, result.getResult());
        
        result = ruleRab.apply(new Float[] {9f, 9f, 11f});
        assertEquals(true, result.isSuccess());
        assertEquals(9f, result.getResult());
    }
    
    public void testComprehensiveCompensation2()
    {
        Predicate<ResistorCompParam> p0 = p -> p.cardType.equals(ALCI) ||  p.cardType.equals(ALCH);
        Predicate<ResistorCompParam> p1 = p -> p.rab < 10f;
        Predicate<ResistorCompParam> p2 = p -> p.rag < 10f;
        Predicate<ResistorCompParam> p3 = p -> p.rbg < 10f;
        
        Predicate<ResistorCompParam> pRag = p0.and(p1.or(p2.negate().and(p3))); 
        
        Rule<Float[], Float> ruleRab = new ResistorCompAtomicRule(pRag, x -> INFINITE_RESISTANT, ALCI).orElse(x -> successResult(x[1]));
        
        Result<Float> result = ruleRab.apply(new Float[] {10f, 11f, 12f});
        assertEquals(true, result.isSuccess());
        assertEquals(11f, result.getResult());
        
        result = ruleRab.apply(new Float[] {11f, 9f, 8f});
        assertEquals(true, result.isSuccess());
        assertEquals(9f, result.getResult());
        
        result = ruleRab.apply(new Float[] {9f, 9f, 11f});
        assertEquals(true, result.isSuccess());
        assertEquals(INFINITE_RESISTANT, result.getResult());
    }
    
    public void testComprehensiveCompensation3()
    {
        Predicate<ResistorCompParam> p0 = p -> p.cardType.equals(ALCI) ||  p.cardType.equals(ALCH);
        Predicate<ResistorCompParam> p1 = p -> p.rab < 10f;
        Predicate<ResistorCompParam> p2 = p -> p.rag < 10f;
        Predicate<ResistorCompParam> p3 = p -> p.rbg < 10f;
        
        Predicate<ResistorCompParam> pRbg = p0.and(p1.or(p2)); 
        
        Rule<Float[], Float> ruleRbg = new ResistorCompAtomicRule(pRbg, x -> INFINITE_RESISTANT, ALCI).orElse(x -> successResult(x[2]));
        
        Result<Float> result = ruleRbg.apply(new Float[] {10f, 11f, 12f});
        assertEquals(true, result.isSuccess());
        assertEquals(12f, result.getResult());
        
        result = ruleRbg.apply(new Float[] {11f, 9f, 8f});
        assertEquals(true, result.isSuccess());
        assertEquals(INFINITE_RESISTANT, result.getResult());
        
        result = ruleRbg.apply(new Float[] {9f, 9f, 11f});
        assertEquals(true, result.isSuccess());
        assertEquals(INFINITE_RESISTANT, result.getResult());
    }
}
