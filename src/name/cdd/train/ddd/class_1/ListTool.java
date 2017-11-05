package name.cdd.train.ddd.class_1;

import java.util.List;

import name.cdd.train.ddd.class_1.ListOper.Combiner;
import name.cdd.train.ddd.class_1.ListOper.Predication;

public class ListTool
{
    public static <T> T find(Predication<T> predication, List<T> list)
    {
        List<T> filteredList = ListOper.filter(predication, list);
        return getFirst(filteredList);
    }
    
    public static <T> boolean all(Predication<T> predication, List<T> list)
    {
        List<T> filteredList = ListOper.filter(predication, list);
        return sameLength(filteredList, list);
    }
    
    public static <T> boolean all2(final Predication<T> predication, List<T> list)
    {
        return ListOper.foldl(new Combiner<Boolean, T>()
        {
            @Override
            public Boolean combine(Boolean acc, T ele)
            {
                return acc && predication.predicate(ele);
            }
        }, true, list);
    }

    public static <T> boolean any(Predication<T> predication, List<T> list)
    {
        List<T> filteredList = ListOper.filter(predication, list);
        return filteredList.size() > 0;
    }

    private static <T> boolean sameLength(List<T> list1, List<T> list2)
    {
        return list1.size() == list2.size();
    }

    private static <T> T getFirst(List<T> list)
    {
        if(list.isEmpty())
        {
            throw new ElementNotFoundException();
        }
        
        return list.get(0);
    }
    
    @SuppressWarnings ("serial")
    static class ElementNotFoundException extends RuntimeException
    {
        public ElementNotFoundException()
        {
            super();
        }
    }

    
}
