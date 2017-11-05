package name.cdd.train.ddd.class_1;

import java.util.ArrayList;
import java.util.List;

import name.cdd.train.ddd.class_1.ListOper.Combiner;
import name.cdd.train.ddd.class_1.ListOper.Predication;

public class ListCalc
{
    public static <T1, T2> boolean isSubset(List<T1> list1, final List<T2> list2)
    {
        return ListOper.foldl(new Combiner<Boolean, T1>()
        {
            @Override
            public Boolean combine(Boolean acc, T1 ele1)
            {
                return acc && list2.contains(ele1);
            }
        }, true, list1);
    }
    
    public static <T1, T2> boolean isSubset2(List<T1> list1, final List<T2> list2)
    {
        return ListTool.all(new Predication<T1>() 
        {
            @Override
            public boolean predicate(T1 ele1)
            {
                return list2.contains(ele1);
            }
            
        }, list1);
    }

    @SuppressWarnings ("serial")
    static class ElementNotFoundException extends RuntimeException
    {
        public ElementNotFoundException()
        {
            super();
        }
    }
    
    public static <T> List<List<T>> combinate(List<T> list,  int n)
    {
        List<List<T>> permutatedList = permutate(list, n);
        
        return ListOper.foldl(new ListOper.Combiner<List<List<T>>, List<T>>()
        {
            @Override
            public List<List<T>> combine(List<List<T>> combinatedList, final List<T> eleOfPermutatedList)
            {
                if(!ListTool.any(new Predication<List<T>>()
                {
                    @Override
                    public boolean predicate(List<T> eleOfCombinatedList)
                    {
                        return hasSameElements(eleOfCombinatedList, eleOfPermutatedList);
                    }
                }, combinatedList))
                {
                    combinatedList.add(eleOfPermutatedList);
                }
                return combinatedList;
            }
        }, new ArrayList<List<T>>(), permutatedList);
    }
    
    private static <T> boolean hasSameElements(List<T> list1, List<T> list2)
    {
        return isSubset(list2, list1) && isSubset(list1, list2);
    }
    
    
//    public static <T> List<List<T>> combinate2(List<T> list, int n)
//    {
//        final List<List<T>> permutatedList = permutate(list, n);
//        
//        return ListOper.foldl(new ListOper.Combiner<List<List<T>>, List<T>>()
//        {
//            @Override
//            public List<List<T>> combine(List<List<T>> combinatedList, List<T> eleOfPermutatedList)
//            {
//                for(List<T> eleOfCombinatedList : combinatedList)
//                {
//                    if(isTwoSetsWithSameElements(eleOfPermutatedList, eleOfCombinatedList))
//                    {
//                        return combinatedList;
//                    }
//                }
//                
//                combinatedList.add(eleOfPermutatedList);
//                return combinatedList;
//            }
//        }, new ArrayList<List<T>>(), permutatedList);
//    }
    
    public static <T> List<List<T>> permutate(List<T> list,  int n)
    {
        if(n == 0)
        {
            return new ArrayList<List<T>>();
        }
        
        return recursivePermutate(list, n - 1, listOfListOfsingleElement(list));
    }

    private static <T> List<List<T>> recursivePermutate(List<T> inputList, int n, final List<List<T>> accList)
    {
        if(n == 0)
        {
            return accList;
        }
        
        final List<List<T>> resultList = new ArrayList<List<T>>();
        
        ListOper.foldl(new Combiner<List<List<T>>, T>()
        {
            @Override
            public List<List<T>> combine(List<List<T>> resultAccList, T eleOfInputList)
            {
                for(List<T> eleAcc : resultAccList)
                {
                    if(!eleAcc.contains(eleOfInputList))
                    {
                        List<T> result = new ArrayList<T>();
                        result.addAll(eleAcc);
                        result.add(eleOfInputList);
                        
                        resultList.add(result);
                    }
                }
                
                return resultAccList;
            }
        }, accList, inputList);
        
        return recursivePermutate(inputList, n - 1, resultList);
    }
    
    /**
     * 返回一个列表，该列表中的每个元素，都是输入列表中的单个元素组成的列表。
     * 例如输入{1, 3, 5}， 返回{{1}, {3}, {5}}
     * @param <T>
     * @param list
     * @return
     */
    private static <T> List<List<T>> listOfListOfsingleElement(List<T> list)
    {
        return ListOper.map(new ListOper.Mapper<T, List<T>>()
        {
            @Override
            public List<T> map(T ele)
            {
                List<T> rtnList = new ArrayList<T>();
                rtnList.add(ele);
                return rtnList;
            }
        
        }, list);
    }
}
