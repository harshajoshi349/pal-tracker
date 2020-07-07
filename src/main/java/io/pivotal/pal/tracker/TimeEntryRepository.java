package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry update(Long id, TimeEntry timeEntry);
    public TimeEntry find(Long id);
    public TimeEntry create(TimeEntry timeEntry);

    void delete(Long id);

    List<TimeEntry> list();

}
