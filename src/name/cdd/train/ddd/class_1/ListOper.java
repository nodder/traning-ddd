package name.cdd.train.ddd.class_1;

import java.util.ArrayList;
import java.util.List;

public class ListOper
{
    private ListOper()
    {
    }
    
    /***********************************  map ****************************/
    
    public static <F, T> List<T> map(Mapper<F, T> mapper, List<F> list)
    {
        List<T> result = new ArrayList<T>();
        
        for(F ele : list)
        {
            result.add(mapper.map(ele));
        }
        
        return result;
    }
    
    public interface Mapper<F, T>
    {
        T map(F ele);
    }
    
    /***********************************  filter ****************************/
    
    public static <E> List<E> filter(Predication<E> predicate, List<E> list)
    {
        List<E> result = new ArrayList<E>();
        
        for(E ele : list)
        {
            if(predicate.predicate(ele))
            {
                result.add(ele);
            }
        }
        
        return result;
    }
    
    public interface Predication<E>
    {
        boolean predicate(E element);
    }
    
    /***********************************  foldl ****************************/
    
    public static <A, E> A foldl(Combiner<A, E> com, A acc, List<E> list)
    {
        for(E ele : list)
        {
            acc = com.combine(acc, ele);
        }
        return acc;
    }
    
    public interface Combiner<A, E>
    {
        A combine(A acc, E ele);
    }
    
}
