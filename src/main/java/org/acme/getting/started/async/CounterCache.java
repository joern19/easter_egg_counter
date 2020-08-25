package org.acme.getting.started.async;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import java.util.Timer;
import java.util.TimerTask;
import javax.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

/**
 *
 * @author not-a-robot
 */
@ApplicationScoped
public class CounterCache {
    
    private long value = 0;
    private boolean isNewValue = false;
    //private final Counter counter;
    private final ObjectId documentId = new ObjectId("5f0de54892a81247850adc38"); 
    
    public CounterCache() {
        //counter = Counter.findById(documentId);
        
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                flush();
            }
        }, 10000); //every 10 secounds (on crash it will be a 10 secound rollback.)
    }
    
    public void addOne() {
        value++;
        isNewValue = true;
    }
    
    public long getValue() {
        return value;
    }
    
    private void flush() {
        //counter.setCounter(value);
        if (isNewValue) {
            PanacheMongoEntity.update("counter", value).where("_id", documentId);
            isNewValue = false;
        }
        //counter.persistOrUpdate();
    }
}
