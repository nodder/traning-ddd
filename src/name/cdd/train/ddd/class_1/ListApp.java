package name.cdd.train.ddd.class_1;

import java.util.List;

import name.cdd.train.ddd.class_1.ListOper.Combiner;
import name.cdd.train.ddd.class_1.ListOper.Mapper;
import name.cdd.train.ddd.class_1.ListOper.Predication;

public class ListApp
{
    /***********************************  Mapper ****************************/
    
    public List<Integer> doubleElements(List<Integer> list)
    {
        return ListOper.map(new Mapper<Integer, Integer>()
            {
            @Override
            public Integer map(Integer ele)
            {
                return ele * 2;
            }
        }, list);
    }

    public List<String> presentElements(List<Integer> list)
    {
        return ListOper.map(new Mapper<Integer, String>()
            {
            @Override
            public String map(Integer ele)
            {
                return ele + "";
            }
        }, list);
    }

    /***********************************  Predication ****************************/
    
    public List<Integer> pickoutEvens(List<Integer> list)
    {
        return ListOper.filter(new Predication<Integer>()
        {
            @Override
            public boolean predicate(Integer element)
            {
                return element % 2 == 0;
            }
        }, list);
    }
    
    public List<Integer> pickoutOdds(List<Integer> list)
    {
        return ListOper.filter(new Predication<Integer>()
        {
            @Override
            public boolean predicate(Integer element)
            {
                return element % 2 == 1;
            }
        }, list);
    }
    
    /*********************************** foldl ****************************/

    public int sumElements(List<Integer> list)
    {
        return ListOper.foldl(new AddCombiner(), 0, list);
    }

    public int productElements(List<Integer> list)
    {
        return ListOper.foldl(new MultiplyCombiner(), 1, list);
    }
    
    class AddCombiner implements Combiner<Integer, Integer>
    {
        @Override
        public Integer combine(Integer acc, Integer ele)
        {
            return acc + ele;
        }
    }
    
    class MultiplyCombiner implements Combiner<Integer, Integer>
    {
        @Override
        public Integer combine(Integer acc, Integer ele)
        {
            return acc * ele;
        }
    }
}
