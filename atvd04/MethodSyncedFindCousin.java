package atvd04;

import java.util.List;

public class MethodSyncedFindCousin implements FindCousin{

    @Override
    public synchronized List<Integer> find(Integer lower_bound, Integer upper_bound, Integer thread_amount) {
        
        
    }

}
