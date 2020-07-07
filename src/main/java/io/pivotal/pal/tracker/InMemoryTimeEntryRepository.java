package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    HashMap<Long,TimeEntry> repo=new HashMap<>();
    Long counter=0L;


    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(++counter);
        repo.put(timeEntry.getId(),timeEntry);

        return repo.get(timeEntry.getId());
    }

    @Override
    public void delete(Long id) {
        repo.remove(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(repo.values());
    }

    @Override
    public TimeEntry find(Long id) {
        return repo.get(id);
    }


    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        TimeEntry temp=repo.get(id);
        if(temp!=null){
            timeEntry.setId(id);
            repo.put(timeEntry.getId(),timeEntry);
            temp=timeEntry;
        }
        return temp;
    }
}
